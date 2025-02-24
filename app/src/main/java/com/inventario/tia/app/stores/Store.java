package com.inventario.tia.app.stores;

import com.inventario.tia.app.stock.Stock;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "stores")
@Table
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int numName;
    private String address;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Stock> stocks;

    public Store() {
    }

    public Store(long id, String name, int numName, String address, List<Stock> stocks) {
        this.id = id;
        this.name = name;
        this.numName = numName;
        this.address = address;
        this.stocks = stocks;
    }

    public Store(String name, int numName, String address, List<Stock> stocks) {
        this.name = name;
        this.numName = numName;
        this.address = address;
        this.stocks = stocks;
    }

    public Store(String name, int numName, String address) {
        this.name = name;
        this.numName = numName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumName() {
        return numName;
    }

    public void setNumName(int numName) {
        this.numName = numName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numName=" + numName +
                ", address='" + address + '\'' +
                ", stocks=" + stocks +
                '}';
    }
}
