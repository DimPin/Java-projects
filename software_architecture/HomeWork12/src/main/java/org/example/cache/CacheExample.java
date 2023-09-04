package org.example.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CacheExample {
    // Создание списка продуктов для примера
    private static List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", 9.99));
        productList.add(new Product(2, "Product 2", 19.99));
        productList.add(new Product(3, "Product 3", 29.99));
        return productList;
    }

    public static void main(String[] args) {
        // Создание списка продуктов
        List<Product> productList = createProductList();

        Cache<String, Product> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();

        for (int i = 0; i < productList.size(); i++) {
            cache.put(String.valueOf(i + 1), productList.get(i));
        }

        String productId = "1";
        Product product = cache.getIfPresent(productId);
        System.out.println("Product from cache: " + product);

        productId = "2";
        product = cache.getIfPresent(productId);
        System.out.println("Product from cache: " + product);

        product.setPrice(17.99);
        System.out.println("Update product from cache: " + product);
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
