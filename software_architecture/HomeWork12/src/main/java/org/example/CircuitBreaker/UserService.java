package org.example.CircuitBreaker;

// Класс, представляющий сервис пользователя
public class UserService {
    private CircuitBreaker circuitBreaker;

    // Конструктор, принимающий экземпляр Circuit Breaker
    public UserService(CircuitBreaker circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

    // Метод для получения информации о пользователе
    public String getUserInfo(int userId) {
        if (!circuitBreaker.allowRequest()) {
            return "Service is unavailable due to Circuit Breaker";
        }

        // Здесь был бы код для получения информации о пользователе
        // В данном примере мы просто имитируем успешный запрос
        return "User info for user " + userId;
    }

    // Метод для сообщения об ошибке в Circuit Breaker
    public void reportFailure() {
        circuitBreaker.recordFailure();
    }

    // Метод для сброса состояния Circuit Breaker
    public void resetCircuitBreaker() {
        circuitBreaker.reset();
    }
}
