package com.adrian.backend.cartapp.backendcartapp;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.adrian.backend.cartapp.backendcartapp.models.entities.Product;
import com.adrian.backend.cartapp.backendcartapp.services.ProductServiceImpl;
import com.adrian.backend.cartapp.backendcartapp.repositories.ProductRepository;


@SpringBootTest
class BackendCartappApplicationTests {
    
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

	@Test
    void testFindAllProducts() {

        Product product1 = new Product();
        product1.setId(20L);
        product1.setName("FUNKO LUFFY");
        product1.setDescription("THE PIRATE KING");
        product1.setPrice(200L);

        Product product2 = new Product();
        product2.setId(21L);
        product2.setName("FUNKO WILLYREX");
        product2.setDescription("THE BEST YOUTUBER");
        product2.setPrice(60L);

        List<Product> productList = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> returnedProducts = productService.findAll();

        verify(productRepository, times(1)).findAll();
        assertEquals(2, returnedProducts.size());
        assertEquals(product1.getName(), returnedProducts.get(0).getName());
        assertEquals(product2.getName(), returnedProducts.get(1).getName());
    }

}
