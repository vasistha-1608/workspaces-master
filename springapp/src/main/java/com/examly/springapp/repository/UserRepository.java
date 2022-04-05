package com.examly.springapp.repository;

import com.examly.springapp.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<UserModel,Long>{
    @Query("SELECT u FROM UserModel u Where u.email = ?1") 
    UserModel findByEmail(String email);
    @Query("SELECT u FROM UserModel u Where u.email = ?1 and u.password = ?2")
    UserModel checkUser(String email,String password) ;
    
    
   
}
