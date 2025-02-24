package com.inventario.tia.app.stock;

import com.inventario.tia.app.products.Product;
import com.inventario.tia.app.products.ProductRepository;
import com.inventario.tia.app.stores.Store;
import com.inventario.tia.app.stores.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Configuration
@Order(3)
public class StockDataLoader implements CommandLineRunner {
    private final StockRepository stockRepository;

    private final StoreRepository storeRepository;

    private final ProductRepository productRepository;

    @Autowired
    public StockDataLoader(StockRepository stockRepository,
                           StoreRepository storeRepository,
                           ProductRepository productRepository) {
        super();
        this.stockRepository = stockRepository;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        Store rotonda = storeRepository.findById(1L).orElse(null);
        Store portete = storeRepository.findById(2L).orElse(null);
        Product galletas = productRepository.findById(1L).orElse(null);
        Product leche = productRepository.findById(2L).orElse(null);

        if (rotonda != null && galletas != null) {
            Stock stock1 = new Stock();
            stock1.setStore(rotonda);
            stock1.setProduct(galletas);
            stock1.setQuantity(30);
            stockRepository.save(stock1);
        }

        if (rotonda != null && leche != null) {
            Stock stock2 = new Stock();
            stock2.setStore(rotonda);
            stock2.setProduct(leche);
            stock2.setQuantity(24);
            stockRepository.save(stock2);
        }

        if (portete != null && galletas != null) {
            Stock stock3 = new Stock();
            stock3.setStore(portete);
            stock3.setProduct(galletas);
            stock3.setQuantity(12);
            stockRepository.save(stock3);
        }

        if (portete != null && leche != null) {
            Stock stock4 = new Stock();
            stock4.setStore(portete);
            stock4.setProduct(leche);
            stock4.setQuantity(18);
            stockRepository.save(stock4);
        }
    }

}
