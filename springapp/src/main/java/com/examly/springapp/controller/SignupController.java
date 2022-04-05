package com.examly.springapp.controller;

import com.examly.springapp.model.UserModel;
import com.examly.springapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("")
public class SignupController {
    @Autowired
    private UserRepository userRepository;

    
  
//creating user
    @PostMapping("/signup")
    public Boolean saveUser(@RequestBody UserModel user){
          user.setActive(false);
          user.setRole("user");
          userRepository.save(user);
          return true;
    }

}
