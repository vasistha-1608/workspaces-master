package com.examly.springapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Cart")
public class CartModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
private String cartItemID;

@Column(length = 512)
private String productName;

@Column(length = 64)
private int quantity;

@Column(length = 64)
private String price;

    public CartModel() {
    }


    public CartModel(String productName, int quantity, String price, UserModel userId) {
        super();
        
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.userId = userId;
    }
   

    @ManyToOne(cascade = CascadeType.MERGE)
    private UserModel userId;
    public UserModel getUserId() {
        return this.userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
    

    public String getCartItemID() {
        return this.cartItemID;
    }

    public void setCartItemID(String cartItemID) {
        this.cartItemID = cartItemID;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
      
}
