package com.inventario.tia.app.stores;

import com.inventario.tia.app.stock.Stock;
import com.inventario.tia.app.stock.StockService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stores")
public class StoreController {

    private final StoreService storeService;
    private final StockService stockService;

    @Autowired
    public StoreController(StoreService storeService, StockService stockService) {
        this.storeService = storeService;
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<Store>> getStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @GetMapping("/{storeId}/stocks")
    public ResponseEntity<List<Stock>> getStockByStoreId (
            @PathVariable() long storeId
    )  throws BadRequestException {
        List<Stock> stockList = stockService.getStockByStoreId(storeId);
        return ResponseEntity.ok(stockList);
    }

    @PostMapping
    public ResponseEntity<Store> registerStore(@RequestBody Store store) throws BadRequestException {
        return ResponseEntity.ok(storeService.registerNewStore(store));
    }

}
