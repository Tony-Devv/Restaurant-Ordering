package Strategy.discount;

import model.Order;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return 0.0;
    }

    @Override
    public String getName() {
        return "No Discount";
    }
}
