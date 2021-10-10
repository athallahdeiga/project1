/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tlate file, choose Tools | Tlates
 * and open the tlate in the editor.
 */
package com.project1.fastar.services;

import com.project1.fastar.interfaces.ProductInterface;
import com.project1.fastar.models.Product;
import com.project1.fastar.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Deiga
 */
@Service
    public class ProductService implements ProductInterface {

        @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void pstore(Product product) {
        this.productRepository.save(product);
    }
    
    @Override
    public Product getById(long id) {
        Optional < Product > optional = productRepository.findById(id);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Product not found for id : " + id);
     }

    Product product = optional.get();
    return product;
    }

    @Override
    public void delete(long id) {
    this.productRepository.deleteById(id);
    }

    
    
}
    

