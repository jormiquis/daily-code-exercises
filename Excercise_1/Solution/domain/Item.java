package com.example.demo.exercises.Solution.domain;

public class Item {
    private String id;
    private double price;
    private int quantity;

    Item(String id,double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public Object getProductId() {
        return this.id;
    }

    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
