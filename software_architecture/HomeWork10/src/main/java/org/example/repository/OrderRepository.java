package org.example.repository;

import org.example.agregator.Order;

import java.util.ArrayList;

public interface OrderRepository {
    void createTable();
    void save(Order order);
    void download(int id);
    void downloadAll(ArrayList orders);
}
