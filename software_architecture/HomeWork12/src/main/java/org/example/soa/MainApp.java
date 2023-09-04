package org.example.soa;

// MainApp.java
public class MainApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        int userId = 123;
        int orderId = 456;

        String userInfo = userService.getUserInfo(userId);
        String orderDetails = orderService.getOrderDetails(orderId);

        System.out.println(userInfo);
        System.out.println(orderDetails);
    }
}
