package com.examly.springapp.controller;

import java.util.List;

import com.examly.springapp.model.OrderModel;
import com.examly.springapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("admin/orders")
    public List<OrderModel> getAdminOrders()
    {
        return orderRepository.findAll();

    }
    
    @PostMapping("/orders/{id}")
   public  ResponseEntity<List<OrderModel>> getUserProducts(@PathVariable String id)
    {
       List<OrderModel> foundoders= orderRepository.findByF(id);
        return ResponseEntity.ok(foundoders);
    }
    @PostMapping("/saveOrder/{id}")
    public void saveProduct(@PathVariable String id,@RequestBody List<OrderModel> orders){
       orderRepository.saveAll(orders);
    } 
    @PostMapping("/placeOrder")
    public void placeOrder(@RequestBody OrderModel order){
        orderRepository.save(order);
    }
}
