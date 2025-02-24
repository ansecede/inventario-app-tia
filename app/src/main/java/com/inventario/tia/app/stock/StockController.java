package com.inventario.tia.app.stock;

import com.inventario.tia.app.stock.dtos.StockUpdateRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stocks")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping()
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @PostMapping("{storeId}")
    public ResponseEntity<Void> updateStock(
            @PathVariable Long storeId,
            @RequestBody StockUpdateRequest request) throws BadRequestException {

        request.setStoreId(storeId);

        stockService.updateStock(request);
        return ResponseEntity.ok().build();
    }

}
