package com.products_api.service;

import com.products_api.model.Product;
import com.products_api.model.ProductDTO;
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

        Product res =  new Product();
        res.setId(1l);res.setName("test");
        List<Product> result = new ArrayList<>();
        result.add(res);
        Mockito.when(repository.findAll()).thenReturn(result);
        List<ProductDTO> data = service.getAllProducts();

        assertEquals(1l,data.get(0).id());
        assertEquals("test",data.get(0).name());
    }

    @Test
    public void saveProductTest(){
        ProductDTO req = new ProductDTO(1l,"test");
        Product res =  new Product();
        res.setId(1l);res.setName("test");
        Mockito.when(repository.save(any(Product.class))).thenReturn(res);
        ProductDTO product = service.saveProduct(req);

        assertEquals(req.id(),res.getId());
        assertEquals(req.name(),res.getName());
        org.mockito.Mockito.verify(repository, org.mockito.Mockito.times(1)).save(any(Product.class));
    }
}
