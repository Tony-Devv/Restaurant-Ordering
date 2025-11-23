package Strategy.payment;

import model.Order;

public interface PaymentStrategy {
    boolean pay(double amount); 
    String getName();

}
