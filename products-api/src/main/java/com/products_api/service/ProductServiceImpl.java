package com.products_api.service;

import com.products_api.model.ProductEntity;
import com.products_api.model.Product;
import com.products_api.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        logger.info("Fetching Products from db");
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Product saveProduct(Product productDTO) {
        ProductEntity product = convertToEntity(productDTO);
        ProductEntity savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    // Convert Product Entity to ProductDTO
    private Product convertToDTO(ProductEntity product) {
        return new Product(product.getName());
    }

    // Convert ProductDTO to Product Entity
    private ProductEntity convertToEntity(Product productDTO) {
        ProductEntity product = new ProductEntity();
        product.setName(productDTO.name());
        return product;
    }
}
