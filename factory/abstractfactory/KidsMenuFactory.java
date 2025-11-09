package factory.abstractfactory;

import model.*;

public class KidsMenuFactory implements MenuFactory {
    
    @Override
    public MenuItem createAppetizer() {
        return new BaseBurger("Mini Chicken Nuggets", 30.0, "Chicken");
    }

    @Override
    public MenuItem createMainCourse() {
        return new BasePizza("Cheese Pizza", 50.0);
    }

    @Override
    public MenuItem createDessert() {
        return new BaseDessert("Ice Cream Sundae", 35.0);
    }

    @Override
    public MenuItem createBeverage() {
        return new BaseBeverage("Chocolate Milk", 18.0);
    }
}
