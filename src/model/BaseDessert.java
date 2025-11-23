package model;


public class BaseDessert implements MenuItem {
    private String name;
    private double basePrice;

    public BaseDessert(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
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
        return "Dessert";
    }
}