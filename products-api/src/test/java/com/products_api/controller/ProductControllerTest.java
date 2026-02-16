package com.products_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.products_api.model.Product;
import com.products_api.model.ProductDTO;
import com.products_api.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    ProductServiceImpl service;

    @BeforeEach
    public void setUp(){
    MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/api/products/listproducts")).andExpect(status().isOk());
    }

    @Test
    public void testCreateProduct() throws Exception {
        ProductDTO product = new ProductDTO(1l,"test");
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(product);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/products")
                        .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                        .content(requestBody);


        mockMvc.perform(requestBuilder).andExpect(status().isOk());


    }
}
