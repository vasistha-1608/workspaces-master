package com.examly.springapp.repository;

import java.util.List;

import com.examly.springapp.model.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<OrderModel,String> {
    @Query("SELECT u FROM OrderModel u Where u.userId=?1")
    List<OrderModel> findByF(String id); 
}
