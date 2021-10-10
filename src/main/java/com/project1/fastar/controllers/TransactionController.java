/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar.controllers;

import com.project1.fastar.interfaces.ProductInterface;
import com.project1.fastar.interfaces.TransactionInterface;
import com.project1.fastar.models.Product;
import com.project1.fastar.models.Transaction;
import com.project1.fastar.models.User;
import java.util.List;
import java.util.function.Supplier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author farha
 */
@Controller 
public class TransactionController { 
 
    @Autowired 
    private TransactionInterface transactionInterface; 
 
    @Autowired 
    private ProductInterface productInterface; 
 
    @GetMapping("/transaction") 
    public String tindex(Model model,  HttpServletRequest request) { 
        HttpSession session = request.getSession(true); 
         
        long id_user = (long) session.getAttribute("id"); 
         
        List<Transaction> transactions = transactionInterface.findByUserId(id_user); 
         
        model.addAttribute("transactions", transactions); 
        return "transaction/tindex"; 
    } 
 
    @GetMapping("/transaction/tcreate") 
    public String tcreate(Model model) { 
 
        List<Product> product = productInterface.getAll(); 
        model.addAttribute("product", product); 
 
        Transaction transaction = new Transaction(); 
        model.addAttribute("transaction", transaction); 
 
        return "transaction/tcreate"; 
    } 
 
    @PostMapping("/transaction/tstore") 
    public String tstore(@ModelAttribute("transaction") Transaction transaction, HttpServletRequest request) { 
        HttpSession session = request.getSession(true); 
         
        User user = new User(); 
        user.setId((long) session.getAttribute("id")); 
         
        transaction.setUser(user); 
 
        transactionInterface.tstore(transaction); 
        return "redirect:/transaction"; 
    } 
 
    @GetMapping("/transaction/{id}/tedit") 
    public String tedit(@PathVariable(value = "id") long id, Model model) { 
        List<Product> product = productInterface.getAll(); 
        model.addAttribute("productr", product); 
         
        Transaction transaction = transactionInterface.getById(id); 
 
        model.addAttribute("transaction", transaction); 
        return "transaction/tedit"; 
    } 
 
    @PostMapping("/transaction/{id}/delete") 
    public String delete(@PathVariable(value = "id") long id) { 
        transactionInterface.delete(id); 
        return "redirect:/transaction"; 
    }
}
