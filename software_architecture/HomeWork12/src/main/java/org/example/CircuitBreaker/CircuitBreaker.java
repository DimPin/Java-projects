package org.example.CircuitBreaker;

// Класс, представляющий паттерн Circuit Breaker
public class CircuitBreaker {
    private boolean isOpen = false;         // Флаг, указывающий, открыт ли Circuit Breaker
    private int failureThreshold = 3;       // Количество ошибок для срабатывания Circuit Breaker
    private int failureCount = 0;           // Счетчик ошибок

    // Метод, разрешающий или блокирующий запросы в зависимости от состояния Circuit Breaker
    public boolean allowRequest() {
        if (isOpen) {
            return false;
        }

        if (failureCount >= failureThreshold) {
            isOpen = true;
            System.out.println("Circuit Breaker opened");
            return false;
        }
        return true;
    }
    // Метод для записи ошибки в Circuit Breaker
    public void recordFailure() {
        failureCount++;
    }
    // Метод для сброса состояния Circuit Breaker
    public void reset() {
        isOpen = false;
        failureCount = 0;
        System.out.println("Circuit Breaker reset");
    }
}

