package com.products_api.service;

import com.products_api.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
}
