/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.fastar.repositories;

import com.project1.fastar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Deiga
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
