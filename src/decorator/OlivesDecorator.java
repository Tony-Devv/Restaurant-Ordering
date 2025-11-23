package decorator;

import model.MenuItem;

public class OlivesDecorator extends AddOnDecorator {
    private static final double OLIVES_PRICE = 12.0;

    public OlivesDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", Olives";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + OLIVES_PRICE;
    }
}