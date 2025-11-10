package observer;

import model.Order;

public interface OrderObserver {
    void update(Order order);
}