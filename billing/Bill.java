package billing;

import model.Order;

public class Bill {
    private final Order order;
    private final double subtotal;
    private final double discount;
    private final double tax;
    private final double total;

    public Bill(Order order, double subtotal, double discount, double tax, double total) {
        this.order = order;
        this.subtotal = subtotal;
        this.discount = discount;
        this.tax = tax;
        this.total = total;
    }

    public String generateReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("===== Receipt =====\n");
        sb.append(order.toString()).append("\n\n");
        sb.append(String.format("Subtotal: $%.2f%n", subtotal));
        sb.append(String.format("Discount: -$%.2f%n", discount));
        sb.append(String.format("Tax (%.2f%%): $%.2f%n", tax > 0 ? (tax / (subtotal - discount) * 100) : 0, tax));
        sb.append(String.format("Total: $%.2f%n", total));
        sb.append("===================\n");
        return sb.toString();
    }

    public double getTotal() {
        return total;
    }
}
