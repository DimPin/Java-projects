package org.example.repository;

import org.example.agregator.Order;
import org.example.agregator.OrderItem;
import org.example.agregator.Product;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        OrderRepository orderRepository = new OrderRepositoryImpl("jdbc:sqlite:orders.db");

        orderRepository.initDatabase();

        Product note = new Product(1, "Note", 100000.0);
        Product book = new Product(2, "Book", 100.0);

        Order order = new Order();

        OrderItem orderItem = new OrderItem(note, 2);
        order.addItem(orderItem);

        OrderItem orderItem3 = new OrderItem(book, 5);
        order.addItem(orderItem3);

        orderRepository.save(order);

        Order lastOrder = orderRepository.getLastOrder();

        if (lastOrder != null) {
            System.out.println("Последний сохраненный заказ:");
            System.out.println(lastOrder);
        } else {
            System.out.println("В базе данных нет заказов");
        }

        int id = 1;
        Order orderbyId = orderRepository.getById(id);

        if (orderbyId != null) {
            System.out.println("Заказ с ID: " + id);
            System.out.println(orderbyId);
        } else {
            System.out.println("Заказа с таким ID не существует");
        }
    }
}