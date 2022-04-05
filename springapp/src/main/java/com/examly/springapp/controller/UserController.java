package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.examly.springapp.model.UserModel;
import com.examly.springapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/{email}")
    public UserModel getUser(@PathVariable String email){

        UserModel user =userRepository.findByEmail(email);
        return user;
    }
    @PostMapping("/admin/users")
    public List<UserModel> getAllUsers(){
    
        return userRepository.findAll();
    }
   @PutMapping(value="user/update/{email}")
   public ResponseEntity<UserModel> updateUser(@PathVariable String email, @RequestBody UserModel userDetails) {
       UserModel user=userRepository.findByEmail(email);
       user.setUsername(userDetails.getUsername());
       user.setPassword(userDetails.getPassword());
       user.setMobileNumber(userDetails.getMobileNumber());
       UserModel updatedUser=userRepository.save(user);
       
       return ResponseEntity.ok(updatedUser);
   }
   @DeleteMapping("user/delete/{email}")
   public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable String email)
   {
       UserModel user=userRepository.findByEmail(email);
       userRepository.delete(user);
       Map<String,Boolean> response=new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
   }
    
}
