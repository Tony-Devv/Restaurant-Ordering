package decorator;

import model.MenuItem;


public class ExtraCheeseDecorator extends AddOnDecorator {
    private static final double EXTRA_CHEESE_PRICE = 15.0;

    public ExtraCheeseDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + EXTRA_CHEESE_PRICE;
    }
}