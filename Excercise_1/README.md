# Refactoring using the Single Responsibility Principle
## Context: Imagine an `OrderProcessor` class that manages orders in an online store. The current class has too many responsibilities.

```java
class OrderProcessor {
    public void processOrder(Order order) {
        // Validate the order
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order cannot be empty");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        // Calculate the total
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        if (total > 100) {
            total = total * 0.9; // 10% discount for large orders
        }
        order.setTotal(total);

        // Save to database
        Database db = new Database();
        db.connect();
        db.save(order);
        db.disconnect();

        // Send confirmation email
        EmailService emailService = new EmailService();
        emailService.sendEmail(order.getCustomer().getEmail(),
                              "Order Confirmation",
                              "Your order has been processed. Total: $" + order.getTotal());

        // Update inventory
        Inventory inventory = new Inventory();
        for (Item item : order.getItems()) {
            inventory.update(item.getProductId(), item.getQuantity());
        }
    }
}
```
## Task: Refactor this class applying the Single Responsibility Principle (SRP), where each class should have only one reason to change.

- ### Identify the different responsibilities in the current code
- ### Create separate classes for each responsibility
- ### Make sure to maintain the same functional behavior
- ### Consider introducing interfaces where appropriate


