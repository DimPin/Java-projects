package org.example.Bulkhead;
// Класс представляет компонент системы (работника)
public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }
    // Метод для выполнения работы компонента
    public void doWork() {
        System.out.println(name + " is performing work.");
    }
}

