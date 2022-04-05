package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Table;


@Table(name="users")
public class LoginModel {
    @Column(unique = true,length = 45)
    private String email;
    @Column(length = 64)
    private String Password;

    public LoginModel() {
    }

    public LoginModel(String email, String Password) {
        super();
        this.email = email;
        this.Password = Password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
