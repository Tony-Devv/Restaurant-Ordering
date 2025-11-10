package Strategy.discount;

import model.MenuItem;
import model.Order;

public class MeatDiscount implements DiscountStrategy {
    private final double amount; // fixed amount per meat item

    public MeatDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateDiscount(Order order) {
        double discount = 0;
        for (MenuItem item : order.getItems()) {
            if ("Meat".equalsIgnoreCase(item.getCategory())) {
                discount += amount * order.getQuantity(item);
            }
        }
        return discount;
    }

    @Override
    public String getName() {
        return "Meat Discount";
    }
}
