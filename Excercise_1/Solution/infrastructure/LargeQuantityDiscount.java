package com.example.demo.exercises.Solution.infrastructure;

import com.example.demo.exercises.Solution.domain.Discount;

class LargeQuantityDiscount implements Discount {
    @Override
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}