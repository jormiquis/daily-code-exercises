package com.example.demo.exercises.Solution.domain;

public interface EventBus {
    void notify(Event event);
}
