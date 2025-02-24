package com.inventario.tia.app.sales;

import com.inventario.tia.app.products.Product;
import com.inventario.tia.app.stores.Store;
import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Sale() {
    }

    public Sale(Long id, int quantity, Store store, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.store = store;
        this.product = product;
    }

    public Sale(int quantity, Store store, Product product) {
        this.quantity = quantity;
        this.store = store;
        this.product = product;
    }

    public Sale(int quantity, Store store) {
        this.quantity = quantity;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Sale{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", store=" + store +
                ", product=" + product +
                '}';
    }
}
