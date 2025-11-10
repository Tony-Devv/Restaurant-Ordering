package Strategy.payment;

import model.Order;

public interface PaymentStrategy {
    boolean pay(double amount); // return true if payment succeeded
    String getName();
}