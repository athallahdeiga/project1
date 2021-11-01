/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar;

import com.project1.fastar.models.Product;
import com.project1.fastar.repositories.ProductRepository;
import com.project1.fastar.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author Deiga
 */
@SpringBootTest
public class ProductIntegrationTests {

    @InjectMocks
    @Autowired
    ProductService service;

    @MockBean
    ProductRepository repository;

    @Test
    public void createProductTest() throws Exception {
        
        Product product = new Product();
        product.setNama("ps4");
        product.setHarga(4000000);
        product.setStock(100);
        product.setJenis("ps4 original");
     

        when(repository.save(product)).thenReturn(product);
        service.pstore(product);
       
    }

    @Test
    public void createProductTestWithEmptyName() throws Exception {
        
        Product product = new Product();
        product.setNama("");
        product.setHarga(4000000);
        product.setStock(100);
        product.setJenis("ps4 original");
     

        when(repository.save(product)).thenReturn(product);
        service.pstore(product);
    }

    @Test
    public void createUserTestWithEmptyHarga() throws Exception {
        
        Product product = new Product();
        product.setNama("ps4");
        product.setHarga(null);
        product.setStock(100);
        product.setJenis("ps4 original");
     

        when(repository.save(product)).thenReturn(product);
        service.pstore(product);
    }
    
     @Test
    public void createUserTestWithEmptyStock() throws Exception {
        
        Product product = new Product();
        product.setNama("ps4");
        product.setHarga(4000000);
        product.setStock(null);
        product.setJenis("ps4 original");
     

        when(repository.save(product)).thenReturn(product);
        service.pstore(product);
}
       @Test
    public void createUserTestWithEmptyJenis() throws Exception {
        
        Product product = new Product();
        product.setNama("ps4");
        product.setHarga(4000000);
        product.setStock(100);
        product.setJenis("");
     

        when(repository.save(product)).thenReturn(product);
        service.pstore(product);
    }
}