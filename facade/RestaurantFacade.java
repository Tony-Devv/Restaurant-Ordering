package facade;

import model.*;
import factory.abstractfactory.*;
import factory.factorymethod.*;
import decorator.*;
import observer.*;

import java.util.Scanner;


public class RestaurantFacade {
    private OrderNotifier orderNotifier;
    private Scanner scanner;

    public RestaurantFacade() {
        this.orderNotifier = new OrderNotifier();
        this.scanner = new Scanner(System.in);
        
        // Register observers (Kitchen and Waiter)
        orderNotifier.attach(new KitchenDisplay("Main Kitchen"));
        orderNotifier.attach(new WaiterDisplay("John"));
    }

    /**
     * Main entry point - displays menu and handles ordering
     */
    public void startOrderingProcess() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   Welcome to Java Restaurant System    ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        Order order = new Order();

        // Step 1: Choose order type
        chooseOrderType(order);

        // Step 2: Display and select from menu
        boolean addingItems = true;
        while (addingItems) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addMenuFamilyItem(order);
                    break;
                case 2:
                    addPizzaItem(order);
                    break;
                case 3:
                    addBurgerItem(order);
                    break;
                case 4:
                    addingItems = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        // Step 3: Place order (notify kitchen and waiter)
        if (!order.getItems().isEmpty()) {
            orderNotifier.placeOrder(order);
            System.out.println("\n💳 Order ready for billing (Hatem Will handle payment)");
        } else {
            System.out.println("No items in order!");
        }
    }

    private void displayMainMenu() {
        System.out.println("\n  ┌─────────────── MAIN MENU ─────────────────┐");
        System.out.println("  │ 1. Browse Menu Families (Veg/NonVeg/Kids) │");
        System.out.println("  │ 2. Order Pizza (Italian/Eastern)          │");
        System.out.println("  │ 3. Order Burger                           │");
        System.out.println("  │ 4. Finish & Place Order                   │");
        System.out.println("  └───────────────────────────────────────────┘");
        System.out.print("Enter choice: ");
    }

    private void chooseOrderType(Order order) {
        System.out.println("Select Order Type:");
        System.out.println("1. Dine-in");
        System.out.println("2. Delivery");
        System.out.println("3. Takeaway");
        System.out.print("Choice: ");
        
        int choice = getUserChoice();
        switch (choice) {
            case 1: order.setOrderType("Dine-in"); break;
            case 2: order.setOrderType("Delivery"); break;
            case 3: order.setOrderType("Takeaway"); break;
            default: order.setOrderType("Dine-in");
        }
        System.out.println("Order type set to: " + order.getOrderType() + "\n");
    }

    private void addMenuFamilyItem(Order order) {
        System.out.println("\nSelect Menu Family:");
        System.out.println("1. Vegetarian Menu");
        System.out.println("2. Non-Vegetarian Menu");
        System.out.println("3. Kids Menu");
        System.out.print("Choice: ");

        int familyChoice = getUserChoice();
        MenuFactory factory = null;

        switch (familyChoice) {
            case 1: factory = new VegetarianMenuFactory(); break;
            case 2: factory = new NonVegetarianMenuFactory(); break;
            case 3: factory = new KidsMenuFactory(); break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\nSelect Item Type:");
        System.out.println("1. Appetizer");
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.println("4. Beverage");
        System.out.print("Choice: ");

        int itemChoice = getUserChoice();
        MenuItem item = null;

        switch (itemChoice) {
            case 1: item = factory.createAppetizer(); break;
            case 2: item = factory.createMainCourse(); break;
            case 3: item = factory.createDessert(); break;
            case 4: item = factory.createBeverage(); break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        // Customize with add-ons (Decorator)
        item = customizeItem(item);
        
        System.out.print("Quantity: ");
        int quantity = getUserChoice();
        
        order.addItem(item, quantity);
        System.out.println("✓ Added: " + item.getDescription() + " x" + quantity);
    }

  
    private void addPizzaItem(Order order) {
        System.out.println("\nSelect Pizza Style:");
        System.out.println("1. Italian Pizza");
        System.out.println("2. Eastern Pizza");
        System.out.print("Choice: ");

        int styleChoice = getUserChoice();
        PizzaFactory factory = null;

        switch (styleChoice) {
            case 1: factory = new ItalianPizzaFactory(); break;
            case 2: factory = new EasternPizzaFactory(); break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.print("Enter pizza type (e.g., Margherita, Pepperoni): ");
        scanner.nextLine(); 

        String pizzaType = scanner.nextLine();

        MenuItem pizza = factory.orderPizza(pizzaType);
        
        // Customize with add-ons (Decorator)
        pizza = customizeItem(pizza);
        
        System.out.print("Quantity: ");
        int quantity = getUserChoice();
        
        order.addItem(pizza, quantity);
        System.out.println("✓ Added: " + pizza.getDescription() + " x" + quantity);
    }

 
    private void addBurgerItem(Order order) {
        BurgerFactory factory = new ClassicBurgerFactory();
        
        System.out.print("Enter burger type (Beef, Chicken, Veggie): ");

        scanner.nextLine();
        
        String burgerType = scanner.nextLine();

        MenuItem burger = factory.orderBurger(burgerType);
        
     
        burger = customizeItem(burger);
        
        System.out.print("Quantity: ");
        int quantity = getUserChoice();
        
        order.addItem(burger, quantity);
        System.out.println("✓ Added: " + burger.getDescription() + " x" + quantity);
    }

   
    private MenuItem customizeItem(MenuItem item) {
        System.out.println("\nCustomize your item (choose add-ons):");
        System.out.println("Current: " + item.getDescription() + " - $" + item.getPrice());
        
        boolean customizing = true;
        while (customizing) {
            System.out.println("\n1. Extra Cheese (+$15)");
            System.out.println("2. Mushrooms (+$20)");
            System.out.println("3. Olives (+$12)");
            System.out.println("4. Spicy Sauce (+$8)");
            System.out.println("5. BBQ Sauce (+$10)");
            System.out.println("6. No more add-ons");
            System.out.print("Choice: ");

            int choice = getUserChoice();
            
            switch (choice) {
                case 1: 
                    item = new ExtraCheeseDecorator(item);
                    System.out.println("Added: Extra Cheese");
                    break;
                case 2: 
                    item = new MushroomDecorator(item);
                    System.out.println("Added: Mushrooms");
                    break;
                case 3: 
                    item = new OlivesDecorator(item);
                    System.out.println("Added: Olives");
                    break;
                case 4: 
                    item = new SpicySauceDecorator(item);
                    System.out.println("Added: Spicy Sauce");
                    break;
                case 5: 
                    item = new BBQSauceDecorator(item);
                    System.out.println("Added: BBQ Sauce");
                    break;
                case 6: 
                    customizing = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            
            if (customizing && choice >= 1 && choice <= 5) {
                System.out.println("Current: " + item.getDescription() + " - $" + item.getPrice());
            }
        }
        
        return item;
    }

    private int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); 
            return -1;
        }
    }
}
