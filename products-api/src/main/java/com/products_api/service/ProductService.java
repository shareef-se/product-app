package com.products_api.service;

import com.products_api.model.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO saveProduct(ProductDTO productDTO);
}
