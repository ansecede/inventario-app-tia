package com.inventario.tia.app.products;

import com.inventario.tia.app.stock.Stock;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "products")
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String skuCode;
    private double price;
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Stock> stocks;

    public Product() {
    }

    public Product(long id, String skuCode, double price, String description, List<Stock> stocks) {
        this.id = id;
        this.skuCode = skuCode;
        this.price = price;
        this.description = description;
        this.stocks = stocks;
    }

    public Product(String skuCode, double price, String description, List<Stock> stocks) {
        this.skuCode = skuCode;
        this.price = price;
        this.description = description;
        this.stocks = stocks;
    }

    public Product(String skuCode, double price, String description) {
        this.skuCode = skuCode;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", skuCode='" + skuCode + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stocks=" + stocks +
                '}';
    }
}
