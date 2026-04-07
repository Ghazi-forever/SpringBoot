package com.cart.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Cart {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private double amount;
    @Column
    private int discount;

    public Cart() {
    }

    public Cart(long id, String name, double amount, int discount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
