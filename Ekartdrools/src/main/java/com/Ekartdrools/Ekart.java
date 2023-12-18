package com.Ekartdrools;
public class Ekart {

    private String product;
    private String cardType;
    private double price;
    private int discount;

    // Constructors, getters, setters
    // Constructor
    public Ekart(String product, String cardType, double price, int discount) {
        this.product = product;
        this.cardType = cardType;
        this.price = price;
        this.discount = discount;
    }

    // Getters and setters for fields
    // ...

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
