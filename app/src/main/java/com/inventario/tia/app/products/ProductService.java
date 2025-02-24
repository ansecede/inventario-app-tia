package com.inventario.tia.app.products;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product registerNewProduct(Product product) throws BadRequestException {
        Product productBySkuCode = productRepository.findProductBySkuCode(product.getSkuCode())
                .orElseThrow(()-> new BadRequestException("Producto de código " + product.getSkuCode() + " ya existe"));


        return productRepository.save(product);
    }
}
