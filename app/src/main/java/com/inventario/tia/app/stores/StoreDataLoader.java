package com.inventario.tia.app.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@Order(2)
public class StoreDataLoader implements CommandLineRunner {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreDataLoader(StoreRepository storeRepository) {
        super();
        this.storeRepository = storeRepository;
    }
    @Override
    public void run(String... args) {
        Store store1 = new Store("Rotonda", 544, "CC La Rotonda");
        Store store2 = new Store("Portete y la 29", 184, "Av. Portete y calle 29");
        Store store3 = new Store("Acacias", 186, "Av. Dr. Gabriel García Moreno, La Acacias");
        Store store4 = new Store("Centro", 101, "Luque y Chimborazo");

        storeRepository.saveAll(List.of(store1, store2, store3, store4));
    }
}
