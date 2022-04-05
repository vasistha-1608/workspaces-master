package com.examly.springapp.repository;

import java.util.List;

import com.examly.springapp.model.CartModel;
import com.examly.springapp.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<CartModel,String>{
@Query("SELECT u FROM CartModel u Where u.userId=?1")
  List<CartModel> findByF(UserModel id);

}
