/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar.interfaces;

import com.project1.fastar.models.Product;
import com.project1.fastar.models.Transaction;
import java.util.List;

/**
 *
 * @author Deiga
 */
public interface ProductInterface {
    List<Product> getAll();
    void pstore(Product product);

     Product getById(long id);

     void delete(long id);

    
}
