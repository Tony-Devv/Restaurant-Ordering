package Strategy.discount;

import model.MenuItem;
import model.Order;

public class PizzaDiscount implements DiscountStrategy {
    private final double percent; 

    public PizzaDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double calculateDiscount(Order order) {
        double discount = 0;
        for (MenuItem item : order.getItems()) {
            if ("Pizza".equalsIgnoreCase(item.getCategory())) {
                discount += item.getPrice() * order.getQuantity(item) * percent;
            }
        }
        return discount;
    }

    @Override
    public String getName() {
        return "Pizza Discount";
    }
}

