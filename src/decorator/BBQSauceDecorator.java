package decorator;

import model.MenuItem;


public class BBQSauceDecorator extends AddOnDecorator {
    private static final double BBQ_SAUCE_PRICE = 10.0;

    public BBQSauceDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + ", BBQ Sauce";
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + BBQ_SAUCE_PRICE;
    }
}