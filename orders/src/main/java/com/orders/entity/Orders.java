package com.orders.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Userid;

    private String customerName;
    //private LocalDate orderDate;

   // private Product product;


    public Orders() {
    }

    public Orders(String customerName) {
        this.customerName = customerName;
    }

    public Long getUserid() {
        return Userid;
    }

    public void setUserid(Long userid) {
        Userid = userid;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

