package org.example.repository;

import org.example.agregator.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderRepositoryImpl implements OrderRepository{
    private Connection connection;

    public OrderRepositoryImpl(String connectionString) {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void download(int id) {

    }

    @Override
    public void downloadAll(ArrayList orders) {

    }
}
