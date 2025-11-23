package factory.abstractfactory;

import model.*;


public class VegetarianMenuFactory implements MenuFactory {
    
    @Override
    public MenuItem createAppetizer() {
        return new BasePizza("Veggie Spring Rolls", 35.0);
    }

    @Override
    public MenuItem createMainCourse() {
        return new BasePizza("Margherita Pizza", 80.0);
    }

    @Override
    public MenuItem createDessert() {
        return new BaseDessert("Fruit Salad", 40.0);
    }

    @Override
    public MenuItem createBeverage() {
        return new BaseBeverage("Fresh Orange Juice", 25.0);
    }
}