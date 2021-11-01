/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar;

import com.project1.fastar.models.Product;
import com.project1.fastar.models.Transaction;
import com.project1.fastar.models.User;
import com.project1.fastar.repositories.TransactionRepository;
import com.project1.fastar.services.TransactionService;
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
public class TransactionIntegrationTests {

    @InjectMocks
    @Autowired
    TransactionService service;

    @MockBean
    TransactionRepository repository;

    @Test
    public void createTransactionTest() throws Exception {
        
        Product pro =  new Product();
        pro.setId(3);
        
        User user =  new User();
        user.setId(2);
        
        Transaction transaction = new Transaction();
        transaction.setProduct(pro);
        transaction.setJumlah(1);
        transaction.setUser(user);
     

        when(repository.save(transaction)).thenReturn(transaction);
        service.tstore(transaction);
       
    }

    @Test
    public void createTransactionTestWithEmptyJumlah() throws Exception {
        
        Product pro =  new Product();
        pro.setId(3);
        
        User user =  new User();
        user.setId(2);
        
        Transaction transaction = new Transaction();
        transaction.setProduct(pro);
        transaction.setJumlah(null);
        transaction.setUser(user);
     

        when(repository.save(transaction)).thenReturn(transaction);
        service.tstore(transaction);
    }

}