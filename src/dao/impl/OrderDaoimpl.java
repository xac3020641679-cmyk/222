package dao.impl;

import dao.OrderDao;
import domain.OrderForm;
import domain.OrderForm.OrderLine;
import util.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoJdbcImpl implements OrderDao {
    private final DataSource dataSource;

    public OrderDaoJdbcImpl() {
        this.dataSource = DruidDataSourceFactory.getDataSource();
    }

    @Override
    public Long createOrder(OrderForm order) throws Exception {
        String insertOrderSql = "INSERT INTO orders (user_id, user_name, phone, seat_info, order_time, total_price, date_string) VALUES (?,?,?,?,?,?,?)";
        String insertLineSql = "INSERT INTO order_lines (order_id, menu_item_id, name, unit, quantity, unit_price, line_total) VALUES (?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement psOrder = null;
        PreparedStatement psLine = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            psOrder = conn.prepareStatement(insertOrderSql, Statement.RETURN_GENERATED_KEYS);
            psOrder.setObject(1, order.getUserId());
            psOrder.setString(2, order.getUserName());
            psOrder.setString(3, order.getPhone());
            psOrder.setString(4, order.getSeatInfo());
            psOrder.setTimestamp(5, Timestamp.valueOf(order.getOrderTime()));
            psOrder.setDouble(6, order.getTotalPrice());
            psOrder.setString(7, order.getDateString());
            psOrder.executeUpdate();
            rs = psOrder.getGeneratedKeys();
            Long orderId = null;
            if (rs.next()) {
                orderId = rs.getLong(1);
            } else {
                throw new SQLException("Failed to obtain order id.");
            }
            psLine = conn.prepareStatement(insertLineSql);
            if (order.getLines() != null) {
                for (OrderLine l : order.getLines()) {
                    psLine.setObject(1, orderId);
                    psLine.setObject(2, l.getMenuItemId());
                    psLine.setString(3, l.getName());
                    psLine.setString(4, l.getUnit());
                    psLine.setInt(5, l.getQuantity());
                    psLine.setDouble(6, l.getUnitPrice());
                    psLine.setDouble(7, l.getLineTotal());
                    psLine.addBatch();
                }
                psLine.executeBatch();
            }
            conn.commit();
            return orderId;
        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { /* ignore */ }
            }
            throw e;
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignore) {}
            try { if (psLine != null) psLine.close(); } catch (Exception ignore) {}
            try { if (psOrder != null) psOrder.close(); } catch (Exception ignore) {}
            try { if (conn != null) conn.close(); } catch (Exception ignore) {}
        }
    }

    @Override
    public boolean hasOrderForUserOnDate(Long userId, String dateString) throws Exception {
        String sql = "SELECT COUNT(1) FROM orders WHERE user_id = ? AND date_string = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, userId);
            ps.setString(2, dateString);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
                return false;
            }
        }
    }

    @Override
    public List<OrderForm> findOrdersByDate(String dateString) throws Exception {
        String sqlOrders = "SELECT id, user_id, user_name, phone, seat_info, order_time, total_price FROM orders WHERE date_string = ? ORDER BY id";
        String sqlLines = "SELECT id, menu_item_id, name, unit, quantity, unit_price, line_total FROM order_lines WHERE order_id = ? ORDER BY id";
        List<OrderForm> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlOrders)) {
            ps.setString(1, dateString);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    OrderForm o = new OrderForm();
                    o.setId(rs.getLong("id"));
                    o.setUserId(rs.getLong("user_id"));
                    o.setUserName(rs.getString("user_name"));
                    o.setPhone(rs.getString("phone"));
                    o.setSeatInfo(rs.getString("seat_info"));
                    Timestamp ts = rs.getTimestamp("order_time");
                    if (ts != null) o.setOrderTime(ts.toLocalDateTime());
                    o.setTotalPrice(rs.getDouble("total_price"));
                    o.setDateString(dateString);

                    // load lines
                    try (PreparedStatement ps2 = conn.prepareStatement(sqlLines)) {
                        ps2.setLong(1, o.getId());
                        try (ResultSet rs2 = ps2.executeQuery()) {
                            List<OrderForm.OrderLine> lines = new ArrayList<>();
                            while (rs2.next()) {
                                OrderForm.OrderLine line = new OrderForm.OrderLine();
                                line.setId(rs2.getLong("id"));
                                line.setMenuItemId(rs2.getLong("menu_item_id"));
                                line.setName(rs2.getString("name"));
                                line.setUnit(rs2.getString("unit"));
                                line.setQuantity(rs2.getInt("quantity"));
                                line.setUnitPrice(rs2.getDouble("unit_price"));
                                line.setLineTotal(rs2.getDouble("line_total"));
                                lines.add(line);
                            }
                            o.setLines(lines);
                        }
                    }
                    result.add(o);
                }
            }
        }
        return result;
    }

    @Override
    public List<OrderForm> findOrdersByMonth(String yearMonth) throws Exception {
        // yearMonth format: yyyy-MM
        String sqlOrders = "SELECT id, user_id, user_name, phone, seat_info, order_time, total_price, date_string FROM orders WHERE date_string LIKE ? ORDER BY date_string, id";
        List<OrderForm> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlOrders)) {
            ps.setString(1, yearMonth + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    OrderForm o = new OrderForm();
                    o.setId(rs.getLong("id"));
                    o.setUserId(rs.getLong("user_id"));
                    o.setUserName(rs.getString("user_name"));
                    o.setPhone(rs.getString("phone"));
                    o.setSeatInfo(rs.getString("seat_info"));
                    Timestamp ts = rs.getTimestamp("order_time");
                    if (ts != null) o.setOrderTime(ts.toLocalDateTime());
                    o.setTotalPrice(rs.getDouble("total_price"));
                    o.setDateString(rs.getString("date_string"));
                    // lines can be loaded on demand; for simplicity load them here similar to findOrdersByDate
                    String sqlLines = "SELECT id, menu_item_id, name, unit, quantity, unit_price, line_total FROM order_lines WHERE order_id = ? ORDER BY id";
                    try (PreparedStatement ps2 = conn.prepareStatement(sqlLines)) {
                        ps2.setLong(1, o.getId());
                        try (ResultSet rs2 = ps2.executeQuery()) {
                            List<OrderForm.OrderLine> lines = new ArrayList<>();
                            while (rs2.next()) {
                                OrderForm.OrderLine line = new OrderForm.OrderLine();
                                line.setId(rs2.getLong("id"));
                                line.setMenuItemId(rs2.getLong("menu_item_id"));
                                line.setName(rs2.getString("name"));
                                line.setUnit(rs2.getString("unit"));
                                line.setQuantity(rs2.getInt("quantity"));
                                line.setUnitPrice(rs2.getDouble("unit_price"));
                                line.setLineTotal(rs2.getDouble("line_total"));
                                lines.add(line);
                            }
                            o.setLines(lines);
                        }
                    }
                    result.add(o);
                }
            }
        }
        return result;
    }
}
