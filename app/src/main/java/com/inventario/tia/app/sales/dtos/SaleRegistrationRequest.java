package com.inventario.tia.app.sales.dtos;

import java.util.List;

public class SaleRegistrationRequest {
    private Long storeId;
    private List<SaleItem> sales;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<SaleItem> getSales() {
        return sales;
    }

    public void setSales(List<SaleItem> sales) {
        this.sales = sales;
    }

    public static class SaleItem {
        private Long productId;
        private int quantity;

        // Getters and Setters
        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
