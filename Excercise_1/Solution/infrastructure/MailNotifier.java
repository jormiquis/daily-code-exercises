package com.example.demo.exercises.Solution.infrastructure;

import com.example.demo.exercises.Solution.domain.Notifier;
import com.example.demo.exercises.Solution.domain.Order;

public class MailNotifier implements Notifier {
    @Override
    public void sendNotification(Order order, double total) {
      System.out.println(
        "Order Confirmation "+ order.getCustomer().getEmail() + " Your order has been processed. Total: $" + total);
    }
}
