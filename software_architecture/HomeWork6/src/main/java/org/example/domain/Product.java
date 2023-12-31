package org.example.domain;

/**
 * Класс Product представляет модель товара в интернет-магазине.
 */
public class Product {
    private String id;
    private String name;
    private double price;

    /**
     * Создает новый экземпляр класса Product.
     *
     * @param id    идентификатор товара.
     * @param name  название товара.
     * @param price цена товара.
     */
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
// Геттеры и сеттеры
}