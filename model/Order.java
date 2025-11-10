package model;

import java.util.*;


public class Order {
    private String orderId;
    private List<MenuItem> items;
    private Map<MenuItem, Integer> quantities;
    private String orderType; // "Dine-in", "Delivery", "Takeaway"
    private Date timestamp;

    public Order() {
        this.orderId = "ORD-" + System.currentTimeMillis();
        this.items = new ArrayList<>();
        this.quantities = new HashMap<>();
        this.orderType = "Dine-in";
        this.timestamp = new Date();
    }

    public void addItem(MenuItem item, int quantity) {
        items.add(item);
        quantities.put(item, quantity);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public int getQuantity(MenuItem item) {
        return quantities.getOrDefault(item, 1);
    }

    public double getSubtotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice() * quantities.get(item);
        }
        return total;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Order Type: ").append(orderType).append("\n");
        sb.append("Time: ").append(timestamp).append("\n");
        sb.append("Items:\n");
        for (MenuItem item : items) {
            sb.append("  - ").append(item.getDescription())
              .append(" x").append(quantities.get(item))
              .append(" = $").append(String.format("%.2f", item.getPrice() * quantities.get(item)))
              .append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", getSubtotal()));
        return sb.toString();
    }
}