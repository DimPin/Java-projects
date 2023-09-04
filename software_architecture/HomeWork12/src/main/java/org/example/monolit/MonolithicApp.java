package org.example.monolit;

// MonolithicApp.java
public class MonolithicApp {
    public static void main(String[] args) {
        int userId = 123;
        int orderId = 456;

        // Здесь бы происходила прямая работа с базой данных или другими компонентами без использования сервисов
        String userInfo = getUserInfoFromDatabase(userId);
        String orderDetails = getOrderDetailsFromDatabase(orderId);

        System.out.println(userInfo);
        System.out.println(orderDetails);
    }

    public static String getUserInfoFromDatabase(int userId) {
        // Логика получения информации о пользователе из базы данных
        return "User info for ID " + userId;
    }

    public static String getOrderDetailsFromDatabase(int orderId) {
        // Логика получения информации о заказе из базы данных
        return "Order details for ID " + orderId;
    }
}