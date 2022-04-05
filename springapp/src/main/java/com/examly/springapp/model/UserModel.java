package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserModel {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;   
 @Column(unique = true,length = 45)
 private String email;
 @Column(length = 64)
 private String password;
 @Column(length = 25)
 private String username;
 @Column(length = 20)
 private String mobileNumber;
 @Column(length = 11)
 private String role;
 @Column(length = 10)
 private Boolean active;
 public UserModel() {
 }
    public UserModel(String email, String password, String username, String mobileNumber, String role, Boolean active) {
        super();
        this.email = email;
        this.password = password;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.role = role;
        this.active = active;
    }
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
   
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean isActive() {
        return this.active;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
}
