package com.inventario.tia.app.stock;

import com.inventario.tia.app.products.Product;
import com.inventario.tia.app.stores.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByStoreAndProduct(Store store, Product product);

    List<Stock> findByStore(Store store);
}
