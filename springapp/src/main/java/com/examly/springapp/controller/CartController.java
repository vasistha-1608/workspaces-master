package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.examly.springapp.model.CartModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.repository.CartRepository;
import com.examly.springapp.repository.UserRepository;

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
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/home/{id}")
    public ResponseEntity<Map<String,Boolean>> addToCart(@PathVariable String id,@RequestBody CartModel cart){
        cart.setUserId(userRepository.findByEmail(id));
      cartRepository.save(cart);
        
        Map<String,Boolean> response=new HashMap<>();
        response.put("Added", Boolean.TRUE);
       return ResponseEntity.ok(response);
    }
    @GetMapping("cart/{id}")
    public List<CartModel> showCart(@PathVariable String id)
    {
        UserModel user=userRepository.findByEmail(id);
       
        return cartRepository.findByF(user);
    }
    @DeleteMapping("cart/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCartItem(@PathVariable String id)
    {
       Optional<CartModel> cartItem=cartRepository.findById(id);
       CartModel cart=cartItem.get();
       cartRepository.delete(cart);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
    }
    @PutMapping("cart/update/{id}")
    public String increamentQuant(@PathVariable String id,@RequestBody CartModel temp)
    {
        Optional<CartModel> cartItem=cartRepository.findById(id);
        CartModel cart=cartItem.get();
        cart.setQuantity(temp.getQuantity());
        cartRepository.save(cart);
          return "true";
    }
}