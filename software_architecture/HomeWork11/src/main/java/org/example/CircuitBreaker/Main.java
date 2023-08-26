package org.example.CircuitBreaker;

// Класс для запуска примера
public class Main {
    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker();
        UserService userService = new UserService(circuitBreaker);

        // Имитируем 5 запросов, включая три ошибки
        for (int i = 0; i < 5; i++) {
            String userInfo = userService.getUserInfo(123);
            System.out.println(userInfo);

            if (i == 2) {
                userService.reportFailure();
            }
        }
        userService.resetCircuitBreaker(); // Сбрасываем Circuit Breaker
        // Пробуем снова после сброса
        String userInfoAfterReset = userService.getUserInfo(123);
        System.out.println(userInfoAfterReset);
    }
}
