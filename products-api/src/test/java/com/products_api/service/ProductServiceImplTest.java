package com.products_api.service;

import com.products_api.model.ProductEntity;
import com.products_api.model.Product;
import com.products_api.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    ProductRepository repository;
    @InjectMocks
    ProductServiceImpl service;

    @Test
    public void getAllProductsTest(){

        ProductEntity res =  new ProductEntity();
        res.setId(1l);res.setName("test");
        List<ProductEntity> result = new ArrayList<>();
        result.add(res);
        Mockito.when(repository.findAll()).thenReturn(result);
        List<Product> data = service.getAllProducts();

        assertEquals("test",data.get(0).name());
    }

    @Test
    public void saveProductTest(){
        Product req = new Product("test");
        ProductEntity res =  new ProductEntity();
        res.setId(1l);res.setName("test");
        Mockito.when(repository.save(any(ProductEntity.class))).thenReturn(res);
        Product product = service.saveProduct(req);


        assertEquals(req.name(),res.getName());
        org.mockito.Mockito.verify(repository, org.mockito.Mockito.times(1)).save(any(ProductEntity.class));
    }
}
