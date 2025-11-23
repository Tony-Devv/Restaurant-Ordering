package factory.factorymethod;

import model.*;


public abstract class BurgerFactory {
    
   
    public abstract MenuItem createBurger(String type);

  
    public MenuItem orderBurger(String type) {
        MenuItem burger = createBurger(type);
        System.out.println("Preparing: " + burger.getDescription());
        return burger;
    }
}