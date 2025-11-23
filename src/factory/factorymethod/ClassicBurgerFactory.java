package factory.factorymethod;

import model.*;


public class ClassicBurgerFactory extends BurgerFactory {
    
    @Override
    public MenuItem createBurger(String type) {
        switch (type.toLowerCase()) {
            case "beef":
                return new BaseBurger("Classic Beef Burger", 110.0, "Meat");
            case "chicken":
                return new BaseBurger("Classic Chicken Burger", 95.0, "Chicken");
            case "veggie":
                return new BaseBurger("Classic Veggie Burger", 80.0, "Veggie");
            case "cheese":
                return new BaseBurger("Classic Cheese Burger", 100.0, "Meat");
            default:
                return new BaseBurger("Classic Burger", 85.0, "Meat");
        }
    }
}