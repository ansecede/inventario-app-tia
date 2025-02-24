package com.inventario.tia.app.sales;

import com.inventario.tia.app.products.Product;
import com.inventario.tia.app.products.ProductRepository;
import com.inventario.tia.app.sales.dtos.SaleRegistrationRequest;
import com.inventario.tia.app.stock.Stock;
import com.inventario.tia.app.stock.StockRepository;
import com.inventario.tia.app.stores.Store;
import com.inventario.tia.app.stores.StoreRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository, StoreRepository storeRepository, ProductRepository productRepository, StockRepository stockRepository) {
        this.saleRepository = saleRepository;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public List<Sale> registerSale(SaleRegistrationRequest request) throws BadRequestException {
        // Check if the store exists
        Store store = storeRepository
                .findById(request.getStoreId())
                .orElseThrow(() -> new BadRequestException("Local solicitado no existe"));

        List<Sale> sales = new ArrayList<>();

        for (SaleRegistrationRequest.SaleItem item : request.getSales()) {
            // Consultamos el producto
            Product product = productRepository
                    .findById(item.getProductId())
                    .orElseThrow(() -> new BadRequestException("Producto solicitado no existe"));

            // Consultamos si el local tiene stock para ese producto
            Stock stock = stockRepository.findByStoreAndProduct(store, product);
            if (stock == null) {
                throw new BadRequestException("No hay stock disponible para el producto: " + product.getDescription());
            }

            if (stock.getQuantity() < item.getQuantity()) {
                throw new BadRequestException("No hay suficiente stock del producto: " + product.getDescription());
            }

            Sale sale = new Sale();
            sale.setStore(store);
            sale.setProduct(product);
            sale.setQuantity(item.getQuantity());
            saleRepository.save(sale);
            sales.add(sale);

            stock.setQuantity(stock.getQuantity() - item.getQuantity());
            stockRepository.save(stock);

        }
        return sales;
    }

}
