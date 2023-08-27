package org.example.presentation;


import org.example.data.InMemoryProductRepository;
import org.example.data.ProductRepository;
import org.example.domain.Product;

import java.util.List;

/**
 * Класс Main отвечает за запуск приложения и управление товарами в интернет-магазине.
 */
public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new InMemoryProductRepository();

        // Добавляем два товара в репозиторий
        Product product1 = new Product("1", "Смартфон", 499.99);
        Product product2 = new Product("2", "Ноутбук", 899.99);
        productRepository.addProduct(product1);
        productRepository.addProduct(product2);

        // Получаем и выводим список всех товаров
        List<Product> products = productRepository.getAllProducts();
        for (Product product : products) {
            System.out.println("Товар: " + product.getName() + ", Цена: $" + product.getPrice());
        }
    }
}