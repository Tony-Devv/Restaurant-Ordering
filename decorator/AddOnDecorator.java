package decorator;

import model.MenuItem;


public abstract class AddOnDecorator implements MenuItem {
    protected MenuItem menuItem;

    public AddOnDecorator(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String getCategory() {
        return menuItem.getCategory();
    }
}