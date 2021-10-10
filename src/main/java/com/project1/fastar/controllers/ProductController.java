/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar.controllers;

import com.project1.fastar.interfaces.ProductInterface;
import com.project1.fastar.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Deiga
 */
@Controller
public class ProductController {


    @Autowired
    private ProductInterface productInterface;

   @GetMapping("/product")
    public String pindex(Model model) {
        model.addAttribute("list", productInterface.getAll());
        return "product/pindex";
    }

@GetMapping("/product/pcreate")
    public String pcreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "product/pcreate";
    }

 @PostMapping("/product/pstore")
   public String pstore(@ModelAttribute("product") Product product) {
        productInterface.pstore(product);
        return "redirect:/product";
    }
    
@GetMapping("/product/{id}/pedit")
    public String pedit(@PathVariable(value = "id") long id, Model model) {
        Product product = productInterface.getById(id);

        model.addAttribute("product", product);
        return "product/pedit";
    }

    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        productInterface.delete(id);
        return "redirect:/product" ;
    } 
}