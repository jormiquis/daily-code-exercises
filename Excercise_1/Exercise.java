import java.util.List;
import java.util.Optional;

import com.example.demo.exercises.Solution.application.CalculatePrice;
import com.example.demo.exercises.Solution.domain.Discount;
import com.example.demo.exercises.Solution.domain.EventBus;
import com.example.demo.exercises.Solution.domain.Notifier;
import com.example.demo.exercises.Solution.domain.Order;
import com.example.demo.exercises.Solution.domain.OrderRepository;

class OrderProcessor {

    CalculatePrice calculatePrice;
    OrderRepository repository;
    Discount discount;
    Notifier notifier;
    EventBus eventBus;

    public OrderProcessor(
        CalculatePrice calculatePriceService,
        OrderRepository repository,
        Discount discount,
        Notifier notifier,
        EventBus eventBus
    ) {
        this.calculatePrice = calculatePriceService;
        this.repository = repository;
        this.discount = discount;
        this.notifier = notifier;
        this.eventBus = eventBus;
    }

    public void processOrder(Order order) {
       // Save to database
       this.repository.save(order);

        //get price
        double total = this.calculatePrice.calculateTotal(order, discount);

        // Send confirmation email
        this.notifier.sendNotification(order,total);

        //Creates event
        Event createdOrderEvent = new Event(order.getItems());
        // Inventory listen and makes its own
        this.eventBus.notify(createdOrderEvent);
    }
}

//Infrastructure

class MailNotifier implements Notifier {
    @Override
    public void sendNotification(Order order, double total) {
      System.out.println(
        "Order Confirmation "+ order.getCustomer().getEmail() + " Your order has been processed. Total: $" + total);
    }
}

class LargeQuantityDiscount implements Discount {
    @Override
    public double applyDiscount(double total) {

        return total * 0.9;
    }
}

//Domain

class Order {
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

class CalculatePrice {
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

interface OrderRepository {
    public Order find(String id);
    public void save(Order order);
}


class Customer {
    String email;

    Customer (String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}

interface Discount {
    double applyDiscount(double total);
}

class Event {
    Object args;
    public Event(Object... args)  {
        this.args = args;
    }
}

interface EventBus {
    void notify(Event event);
}


class Item {
    private String id;
    private double price;
    private int quantity;

    Item(String id,double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public String getProductId() {
        return this.id;
    }

    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

 interface Notifier {
    public void sendNotification(Order order, double total);
}