package com.example.demo.exercises.Solution.domain;

import java.util.List;

public class Order {
    private List<Item> items;
    private Customer customer;
    private String id;

    public Order(
        List<Item> items, Customer customer, String id) throws IllegalArgumentException {

         if (items.isEmpty()) {
            throw new IllegalArgumentException("Order cannot be empty");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        this.id = id;
        this.items = items;
        this.customer = customer;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public String getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }
}