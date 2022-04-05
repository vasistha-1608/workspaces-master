package com.examly.springapp.controller;

import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("")
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    
    public ResponseEntity<UserModel> checkUser(@RequestBody LoginModel log1){
    
         UserModel user =userRepository.checkUser(log1.getEmail(), log1.getPassword());
         user.setActive(true);
         userRepository.save(user);
         
         return ResponseEntity.ok(user);
     
    }
    @PostMapping("/logout")
    public String logout(@RequestBody LoginModel log1)
    {
       UserModel user= userRepository.findByEmail(log1.getEmail());
       user.setActive(false);
       userRepository.save(user);
       return "logged out";
    }

}
