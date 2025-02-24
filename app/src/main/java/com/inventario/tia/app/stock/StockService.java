package com.inventario.tia.app.stock;

import com.inventario.tia.app.products.Product;
import com.inventario.tia.app.products.ProductRepository;
import com.inventario.tia.app.stock.dtos.StockUpdateRequest;
import com.inventario.tia.app.stores.Store;
import com.inventario.tia.app.stores.StoreRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    @Autowired
    public StockService(
            StockRepository stockRepository,
            StoreRepository storeRepository,
            ProductRepository productRepository
    )
    {
        this.stockRepository = stockRepository;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public List<Stock> getStockByStoreId(Long storeId) throws BadRequestException {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new BadRequestException("Local solicitado no existe"));
        return stockRepository.findByStore(store);
    }

    public void updateStock(StockUpdateRequest request) throws BadRequestException {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new BadRequestException("Local " + request.getStoreId() + " no existe"));

        for (Map.Entry<Long, Integer> entry : request.getProductQuantities().entrySet()) {
            Long productId = entry.getKey();
            int quantity = entry.getValue();

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new BadRequestException("Producto " + productId + " no existe"));

            Stock stock = stockRepository.findByStoreAndProduct(store, product);
            if (stock != null) {
                // Si ya existe solo actualizamos la cantidad
                stock.setQuantity(stock.getQuantity() + quantity);
            } else {
                // Si no existe, registramos un nuevo stock para el producto.
                stock = new Stock(quantity, store, product);
            }
            stockRepository.save(stock);
        }
    }
}
