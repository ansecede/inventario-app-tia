package com.inventario.tia.app.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@Order(1)
public class ProductDataLoader implements CommandLineRunner{
    private final ProductRepository productRepository;

    @Autowired
    public ProductDataLoader(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        Product product1 = new Product("250101000", .95, "Galletas Muecas");
        Product product2 = new Product("330101000", 1.45, "Leche Entera TaRiko 1L");
        Product product3 = new Product("300101000", 3.1, "Pechuga de Pollo");
        Product product4 = new Product("240101000", 6.99, "Shampoo Sedal");

        productRepository.saveAll(List.of(product1,product2, product3, product4));

    }
}
