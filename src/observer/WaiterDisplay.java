package observer;

import model.Order;


public class WaiterDisplay implements OrderObserver {
    private String waiterName;

    public WaiterDisplay(String waiterName) {
        this.waiterName = waiterName;
    }

    @Override
    public void update(Order order) {
        System.out.println("\n [WAITER - " + waiterName + "]");
        System.out.println("New Order Alert: " + order.getOrderId());
        System.out.println("Order Type: " + order.getOrderType());
        System.out.println("Total Items: " + order.getItems().size());
        System.out.println("Ready to serve!");
    }
}