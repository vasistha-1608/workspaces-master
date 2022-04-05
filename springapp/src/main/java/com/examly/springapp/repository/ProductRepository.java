package com.examly.springapp.repository;

import com.examly.springapp.model.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,String>{
    
}
