package com.inventario.tia.app.stock.dtos;

import java.util.Map;

public class StockUpdateRequest {
    private Long storeId;
    private Map<Long, Integer> productQuantities; // productId -> quantity

    // Getters and Setters
    public Map<Long, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Long, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}

