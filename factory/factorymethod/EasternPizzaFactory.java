package factory.factorymethod;

import model.*;

public class EasternPizzaFactory extends PizzaFactory {
    
    @Override
    public MenuItem createPizza(String type) {
        switch (type.toLowerCase()) {
            case "shawarma":
                return new BasePizza("Shawarma Pizza", 105.0);
            case "tandoori chicken":
                return new BasePizza("Tandoori Chicken Pizza", 115.0);
            case "spicy paneer":
                return new BasePizza("Spicy Paneer Pizza", 95.0);
            case "kebab":
                return new BasePizza("Kebab Pizza", 120.0);
            default:
                return new BasePizza("Eastern Classic Pizza", 100.0);
        }
    }
}
