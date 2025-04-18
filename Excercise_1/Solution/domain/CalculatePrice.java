package com.example.demo.exercises.Solution.domain;

public class CalculatePrice {

    public double calculateTotal(Order order, Discount discount) {
        double total = calculateItemsTotal(order);
        return discount.applyDiscount(total);
    }

    private double calculateItemsTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}