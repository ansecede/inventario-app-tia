package com.inventario.tia.app.sales;

import com.inventario.tia.app.sales.dtos.SaleRegistrationRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sales")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        return ResponseEntity.ok(sales);
    }

    @PostMapping()
    public ResponseEntity<List<Sale>> registerSale(
            @RequestBody SaleRegistrationRequest request) throws BadRequestException {
        List<Sale> sale = saleService.registerSale(request);
        return ResponseEntity.ok(sale);
    }
}