package factory.factorymethod;

import model.*;


public class ItalianPizzaFactory extends PizzaFactory {
    
    @Override
    public MenuItem createPizza(String type) {
        switch (type.toLowerCase()) {
            case "margherita":
                return new BasePizza("Italian Margherita Pizza", 95.0);
            case "pepperoni":
                return new BasePizza("Italian Pepperoni Pizza", 110.0);
            case "quattro formaggi":
                return new BasePizza("Italian Quattro Formaggi Pizza", 125.0);
            case "vegetariana":
                return new BasePizza("Italian Vegetariana Pizza", 100.0);
            default:
                return new BasePizza("Italian Classic Pizza", 90.0);
        }
    }
}