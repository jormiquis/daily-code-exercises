package com.example.demo.exercises.Solution.domain;

public interface OrderRepository {
    public Order find(String id);
    public void save(Order order);
}
