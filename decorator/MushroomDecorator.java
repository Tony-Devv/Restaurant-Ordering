package decorator;

import model.MenuItem;


public class MushroomDecorator extends AddOnDecorator {
    private static final double MUSHROOM_PRICE = 20.0;

    public MushroomDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", Mushrooms";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + MUSHROOM_PRICE;
    }
}
