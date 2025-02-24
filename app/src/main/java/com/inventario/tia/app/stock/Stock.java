package com.inventario.tia.app.stock;

import com.inventario.tia.app.products.Product;
import com.inventario.tia.app.stores.Store;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "stocks")
@Table
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Stock() {
    }

    public Stock(long id, int quantity, Store store, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.store = store;
        this.product = product;
    }

    public Stock(int quantity, Store store, Product product) {
        this.quantity = quantity;
        this.store = store;
        this.product = product;
    }

    public Stock(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", store=" + store +
                ", product=" + product +
                '}';
    }
}

