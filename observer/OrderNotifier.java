package observer;

import model.Order;
import java.util.ArrayList;
import java.util.List;


public class OrderNotifier implements OrderSubject {
    private List<OrderObserver> observers;

    public OrderNotifier() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(OrderObserver observer) {
        observers.add(observer);
        // System.out.println(observer.getClass().getSimpleName() + " subscribed to order notifications.");
    }

    @Override
    public void detach(OrderObserver observer) {
        observers.remove(observer);
        System.out.println(observer.getClass().getSimpleName() + " unsubscribed from order notifications.");
    }

    @Override
    public void notifyObservers(Order order) {
        System.out.println("\n Notifying all systems about new order...");
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }

    /**
     * Place order and notify all observers
     */
    public void placeOrder(Order order) {
        System.out.println("\n Order Placed Successfully!");
        System.out.println(order);
        notifyObservers(order);
        
    }
    
}