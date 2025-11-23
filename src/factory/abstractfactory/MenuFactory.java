package factory.abstractfactory;

import model.MenuItem;

public interface MenuFactory {
    MenuItem createAppetizer();
    MenuItem createMainCourse();
    MenuItem createDessert();
    MenuItem createBeverage();
}