package com.example.demo.exercises.Solution.domain;

public interface Notifier {
    public void sendNotification(Order order, double total);
}
