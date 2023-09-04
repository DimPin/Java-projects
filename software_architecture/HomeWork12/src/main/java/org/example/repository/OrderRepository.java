package org.example.repository;

import org.example.agregator.Order;
import org.example.agregator.OrderItem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {
    void initDatabase() throws SQLException;
    void save(Order order) throws SQLException;
    Order getLastOrder() throws SQLException;
    Order getById(int id) throws SQLException;
    List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException;
}
