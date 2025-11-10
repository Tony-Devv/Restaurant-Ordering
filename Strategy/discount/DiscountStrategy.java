package Strategy.discount;

import model.Order;

public interface DiscountStrategy {
    double calculateDiscount(Order order); // return value to subtract from subtotal
    String getName();
}
