package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.examly.springapp.model.ProductModel;
import com.examly.springapp.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

     /* to get the all  products as admin */

    @GetMapping("/admin")
    public List<ProductModel> getProduct()
    {
          return productRepository.findAll();
    }

     @PostMapping("admin/addProduct")
     public  ResponseEntity<Map<String,Boolean>> productSave(@RequestBody ProductModel product)
     {
        productRepository.save(product);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Added", Boolean.TRUE);
         return ResponseEntity.ok(response);
     }
    /* to delete the  product by id */

    @DeleteMapping("admin/delete/{id}")
    public ResponseEntity<Map<String,Boolean>>  productDelete(@PathVariable String id)
    {
        ProductModel product= productRepository.getById(id);
        productRepository.delete(product);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /* to get the all  products as user */

    @GetMapping("/home")
    List<ProductModel> getHomeProduct()
    {
        return productRepository.findAll();  
    }
  

    /* to edit the product by id */

    @PutMapping(value="admin/productEdit/{id}")
    public ResponseEntity<Map<String,Boolean>> productEditSave(@PathVariable String id,@RequestBody ProductModel productsDetails) {
        ProductModel product= productRepository.getById(id);
        
         product.setProductName(productsDetails.getProductName());
         product.setImageUrl(productsDetails.getImageUrl());
         product.setPrice(productsDetails.getPrice());
         product.setDescription(productsDetails.getDescription());
         product.setQuantity(productsDetails.getQuantity());
         productRepository.save(product);
        Map<String,Boolean> response=new HashMap<>();
        response.put("updated", Boolean.TRUE);
        return ResponseEntity.ok(response);
       
    }
    /* to get the product by id */

    @GetMapping("admin/productEdit/{id}")
   public  ResponseEntity<Optional<ProductModel>> productEditData(@PathVariable String id)
   {
        return ResponseEntity.ok(productRepository.findById(id));
   }
}
