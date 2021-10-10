/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar.services;

import com.project1.fastar.interfaces.TransactionInterface;
import com.project1.fastar.models.Product;
import com.project1.fastar.models.Transaction;
import com.project1.fastar.repositories.TransactionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author farha
 */
@Service 
public class TransactionService implements TransactionInterface { 
    @Autowired 
    private TransactionRepository transactionRepository; 
     
    @Override 
    public List<Transaction> getAll() { 
        return transactionRepository.findAll(); 
    } 
 
    @Override 
    public void tstore(Transaction transaction) { 
        this.transactionRepository.save(transaction); 
    } 
     
    @Override 
    public Transaction getById(long id) { 
        Optional < Transaction > optional = transactionRepository.findById(id); 
 
     if (!optional.isPresent()) { 
        throw new RuntimeException(" Transaction not found for id : " + id); 
     } 
 
    Transaction transaction = optional.get(); 
    return transaction; 
    } 
 
    @Override 
    public void delete(long id) { 
    this.transactionRepository.deleteById(id); 
    } 
     
    @Override 
    public List<Transaction> findByUserId(long id_user) { 
        return transactionRepository.findByUserId(id_user); 
    } 
}
