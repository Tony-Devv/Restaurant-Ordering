package decorator;

import model.MenuItem;


public class SpicySauceDecorator extends AddOnDecorator {
    private static final double SPICY_SAUCE_PRICE = 8.0;

    public SpicySauceDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", Spicy Sauce";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + SPICY_SAUCE_PRICE;
    }
}