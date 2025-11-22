package billing;

import Strategy.discount.DiscountStrategy;
import model.Order;
import Strategy.payment.PaymentStrategy;

public class BillingService {
    private final TaxCalculator taxCalculator;
    private DiscountStrategy discountStrategy;

    public BillingService(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
        this.discountStrategy = null; 
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public Bill checkout(Order order, PaymentStrategy paymentStrategy) {
        double subtotal = order.getSubtotal();
        double discount = 0;
        if (discountStrategy != null) discount = discountStrategy.calculateDiscount(order);

        double taxable = Math.max(0, subtotal - discount);
        double tax = taxCalculator.calculateTax(taxable);
        double total = taxable + tax;

        Bill bill = new Bill(order, subtotal, discount, tax, total);

        boolean paid = paymentStrategy.pay(total);
        if (paid) {
            System.out.println("Payment successful via " + paymentStrategy.getName());
            System.out.println(bill.generateReceipt());
        } else {
            System.out.println("Payment failed. Please try another method.");
        }

        return bill;
    }
}

