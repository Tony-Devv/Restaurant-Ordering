package model;

public interface MenuItem {
    String getDescription();
    double getPrice();
    String getCategory(); // For discount calculation (Hatem use This for Discount
}