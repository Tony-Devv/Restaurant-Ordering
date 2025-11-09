package factory.factorymethod;

import model.*;


public abstract class PizzaFactory {
    
   
    public abstract MenuItem createPizza(String type);

    public MenuItem orderPizza(String type) {
        MenuItem pizza = createPizza(type);
        System.out.println("Preparing: " + pizza.getDescription());
        return pizza;
    }
}
