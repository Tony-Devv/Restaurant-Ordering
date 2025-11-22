package Strategy.discount;

import model.Order;

public interface DiscountStrategy {
    double calculateDiscount(Order order); 
    String getName();
}

