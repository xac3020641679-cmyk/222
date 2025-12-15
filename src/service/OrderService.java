package service;

import dao.OrderDao;
import domain.OrderForm;
import util.ConfigUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderService {
    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    // 判断是否在订餐截止时间之前（可配置）
    public boolean isBeforeCutoff() {
        String cutoff = ConfigUtil.get("order.cutoff", "09:00"); // 默认09:00
        LocalTime cutoffTime = LocalTime.parse(cutoff, DateTimeFormatter.ofPattern("HH:mm"));
        return LocalTime.now().isBefore(cutoffTime);
    }

    // 下单（返回订单ID），会检查当天是否已有订单
    public Long submitOrder(OrderForm order) throws Exception {
        String today = LocalDate.now().toString();
        if (!isBeforeCutoff()) {
            throw new IllegalStateException("已过订餐截止时间，无法下单。");
        }
        if (orderDao.hasOrderForUserOnDate(order.getUserId(), today)) {
            throw new IllegalStateException("用户当天已下过订单，每人每天只能一单。");
        }
        order.setOrderTime(java.time.LocalDateTime.now());
        order.setDateString(today);
        // 计算 total
        double total = 0.0;
        if (order.getLines() != null) {
            for (OrderForm.OrderLine line : order.getLines()) {
                line.setLineTotal(line.getUnitPrice() * line.getQuantity());
                total += line.getLineTotal();
            }
        }
        order.setTotalPrice(total);
        return orderDao.createOrder(order);
    }

    // 获取当天所有订单（用于配餐/打印）
    public List<OrderForm> getTodayOrders() throws Exception {
        String today = LocalDate.now().toString();
        return orderDao.findOrdersByDate(today);
    }

    // 获取指定月份订单（用于统计）
    public List<OrderForm> getMonthOrders(String yearMonth) throws Exception {
        return orderDao.findOrdersByMonth(yearMonth);
    }
}
