package com.cart.data;

import jakarta.persistence.Column;

public class CartData {
    private long id;
    private String name;
    private double amount;
    private int discount;

    public CartData(long id, String name, double amount, int discount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.discount = discount;
    }

    public CartData() {
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

    @Override
    public String toString() {
        return "CartData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}

 /*// canonical constructor and uses a default value
    public CartData() {
        this(0,"",0,0);*/