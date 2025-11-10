package observer;

import model.Order;
import model.MenuItem;


public class KitchenDisplay implements OrderObserver {
    private String kitchenName;

    public KitchenDisplay(String kitchenName) {
        this.kitchenName = kitchenName;
    }

    @Override
    public void update(Order order) {
        System.out.println("\n [KITCHEN - " + kitchenName + "]");
        System.out.println("New Order Received: " + order.getOrderId());
        System.out.println("Items to prepare:");
        for (MenuItem item : order.getItems()) {
            System.out.println("  - " + item.getDescription() + " x" + order.getQuantity(item));
        }
        System.out.println("Starting preparation...");
    }
}