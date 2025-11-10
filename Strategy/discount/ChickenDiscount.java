package Strategy.discount;

import model.MenuItem;
import model.Order;

public class ChickenDiscount implements DiscountStrategy {
    private final double percent;

    public ChickenDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double calculateDiscount(Order order) {
        double discount = 0;
        for (MenuItem item : order.getItems()) {
            if ("Chicken".equalsIgnoreCase(item.getCategory())) {
                discount += item.getPrice() * order.getQuantity(item) * percent;
            }
        }
        return discount;
    }

    @Override
    public String getName() {
        return "Chicken Discount";
    }
}
