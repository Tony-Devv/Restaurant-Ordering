package factory.abstractfactory;

import model.*;


public class NonVegetarianMenuFactory implements MenuFactory {
    
    @Override
    public MenuItem createAppetizer() {
        return new BaseBurger("Chicken Wings", 45.0, "Chicken");
    }

    @Override
    public MenuItem createMainCourse() {
        return new BaseBurger("Beef Burger", 120.0, "Meat");
    }

    @Override
    public MenuItem createDessert() {
        return new BaseDessert("Chocolate Lava Cake", 60.0);
    }

    @Override
    public MenuItem createBeverage() {
        return new BaseBeverage("Cola", 20.0);
    }
}