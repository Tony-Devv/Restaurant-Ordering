package model;


public class BaseBurger implements MenuItem {
    private String name;
    private double basePrice;
    private String category; // "Chicken" or "Meat" for discount

    public BaseBurger(String name, double basePrice, String category) {
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
