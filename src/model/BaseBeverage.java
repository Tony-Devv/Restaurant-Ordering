package model;


public class BaseBeverage implements MenuItem {
    private String name;
    private double basePrice;

    public BaseBeverage(String name, double basePrice) {
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
        return "Beverage";
    }
}