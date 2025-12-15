package dao;

import domain.OrderForm;
import java.util.List;

public interface OrderDao {
    // 插入订单（包含明细）
    Long createOrder(OrderForm order) throws Exception;

    // 查询指定用户在指定日期是否已下单（dateString 格式 yyyy-MM-dd）
    boolean hasOrderForUserOnDate(Long userId, String dateString) throws Exception;

    // 查询某天所有订单（用于打印/配餐）
    List<OrderForm> findOrdersByDate(String dateString) throws Exception;

    // 查询月份统计（聚合） yearMonth 格式 yyyy-MM
    List<OrderForm> findOrdersByMonth(String yearMonth) throws Exception;
}