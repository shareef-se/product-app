package com.products_api.controller;

import com.products_api.model.ProductDTO;
import com.products_api.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listproducts")
    public List<ProductDTO> getAllProducts() {
        logger.info("getAllProducts invoke");
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        logger.info("Create product invoke");
        return productService.saveProduct(productDTO);
    }

}
