import java.util.List;

// Domain layer
class Order {
    private List<Item> items;
    private Customer customer;
    private String id;

    public Order(List<Item> items, Customer customer, String id) throws IllegalArgumentException {
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

class Item {
    private String id;
    private double price;
    private int quantity;

    Item(String id, double price, int quantity) {
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

class Customer {
    String email;

    Customer(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}

// Application layer
interface Discount {
    double applyDiscount(double total);
}

class LargeQuantityDiscount implements Discount {
    @Override
    public double applyDiscount(double total) {
        return total * 0.9;
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

// Infrastructure layer
interface Notifier {
    void sendNotification(Order order, double total);
}

class MailNotifier implements Notifier {
    @Override
    public void sendNotification(Order order, double total) {
        System.out.println("Order Confirmation to " + order.getCustomer().getEmail() + ": Your order has been processed. Total: $" + total);
    }
}

interface OrderRepository {
    Order find(String id);
    void save(Order order);
}

class InMemoryOrderRepository implements OrderRepository {
    @Override
    public Order find(String id) {
        return null; // Implement finding order logic here
    }

    @Override
    public void save(Order order) {
        // Implement saving order logic here
        System.out.println("Order saved: " + order.getId());
    }
}

interface EventBus {
    void notify(Event event);
}

class EventBusImpl implements EventBus {
    @Override
    public void notify(Event event) {
        // Implement event handling logic here
        System.out.println("Event notified: " + event);
    }
}

class Event {
    Object args;
    public Event(Object... args) {
        this.args = args;
    }
}

// Main Processor
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

        // Get price with discount
        double total = this.calculatePrice.calculateTotal(order, discount);

        // Send confirmation email
        this.notifier.sendNotification(order, total);

        // Create event and notify
        Event createdOrderEvent = new Event(order.getItems());
        this.eventBus.notify(createdOrderEvent);
    }
}

// Main class to run the process
public class IaSolution {
    public static void main(String[] args) {
        // Setup
        Item item1 = new Item("1", 20.0, 2);
        Item item2 = new Item("2", 50.0, 1);
        List<Item> items = List.of(item1, item2);

        Customer customer = new Customer("customer@example.com");

        Order order = new Order(items, customer, "order123");

        OrderRepository repository = new InMemoryOrderRepository();
        Discount discount = new LargeQuantityDiscount();
        Notifier notifier = new MailNotifier();
        EventBus eventBus = new EventBusImpl();

        CalculatePrice calculatePrice = new CalculatePrice();
        OrderProcessor processor = new OrderProcessor(calculatePrice, repository, discount, notifier, eventBus);

        // Process order
        processor.processOrder(order);
    }
}
