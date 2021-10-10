/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar.interfaces;

import com.project1.fastar.models.Transaction;
import java.util.List;

/**
 *
 * @author farha
 */
public interface TransactionInterface {
    List<Transaction> getAll();
    void tstore(Transaction transaction);
    Transaction getById(long id);
    void delete(long id);
    List<Transaction> findByUserId(long id_user);
}