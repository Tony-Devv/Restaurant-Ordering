package Strategy.discount;

import model.MenuItem;
import model.Order;

public class DiscountFactory {

    public static DiscountStrategy getDiscountForOrder(Order order) {
        boolean hasPizza = false;
        boolean hasChicken = false;
        boolean hasMeat = false;
        
        for (MenuItem item : order.getItems()) {
            String category = item.getCategory();
            if ("Pizza".equalsIgnoreCase(category)) {
                hasPizza = true;
            } else if ("Chicken".equalsIgnoreCase(category)) {
                hasChicken = true;
            } else if ("Meat".equalsIgnoreCase(category)) {
                hasMeat = true;
            }
        }
        
        // HardCoded for now , Since it's Business Logic not design logic
        if (hasPizza) {
            return new PizzaDiscount(0.10);
        } else if (hasChicken) {
            return new ChickenDiscount(0.08);
        } else if (hasMeat) {
            return new MeatDiscount(7.0);
        } else {
            return new NoDiscount();
        }
    }

    public static DiscountStrategy getDiscountByType(String discountType, double value) {
        switch (discountType.toLowerCase()) {
            case "pizza":
                return new PizzaDiscount(value);
            case "chicken":
                return new ChickenDiscount(value);
            case "meat":
                return new MeatDiscount(value);
            case "none":
            default:
                return new NoDiscount();
        }
    }
}
