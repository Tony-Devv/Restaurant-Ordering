package Strategy.payment;

import model.Order;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.printf("Processing Cash payment of $%.2f ... Done.%n", amount);
        return true;
    }

    @Override
    public String getName() {
        return "Cash";
    }
}