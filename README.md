# Restaurant Ordering & Billing System — README

## Overview
This project simulates a restaurant ordering and billing system demonstrating multiple design patterns: Strategy, Factory Method, Abstract Factory, Decorator, Observer, and Facade. It is a console-based Java application.

## Example test case 1 :
1. Run your compiled Java program (`Main`).
2. Follow the menu:
   - Select Order Type: `1` (Dine-in)
   - Main Menu: `1` (Browse Menu Families)
   - Menu Family: `1` (Vegetarian)
   - Item Type: `2` (Main Course — Margherita Pizza)
   - Customize: `1` (Extra Cheese), `2` (Mushrooms), `6` (No more add-ons)
   - Quantity: `1`
   - Main Menu: `2` (Order Pizza)
   - Pizza Style: `1` (Italian)
   - Pizza Type: `Pepperoni`
   - Customize: `5` (BBQ Sauce), `6` (No more add-ons)
   - Quantity: `2`
   - Main Menu: `4` (Finish & Place Order)
   - Payment: `1` (Cash)

Expected: Kitchen + Waiter notified, receipt printed with subtotal, discounts, tax, total.


## Example test case 2 :
1. Run your compiled Java program (`Main`).
2. Follow the menu:
   - Select Order Type: `3` (Takeaway)
   - Main Menu: `2` (Order Pizza)
   - Pizza Style: `2` (Eastern)
   - Pizza Type: `Chicken Ranch`
   - Customize: `1` (Spicy Sauce), `6` (No more add-ons)
   - Quantity: `3`
   - Main Menu: `3` (Order Burger)
   - Burger Type: (Classic Beef Burger)
   - Customize: `5` (BBQ Sauce), `6` (No more add-ons)
   - Quantity: `2`
   - Main Menu: `4` (Finish & Place Order)
   - Payment: `3` (Mobile Wallet)

Expected: Chicken Discount applied , Observer pattern triggers notifications
	  Total = Subtotal – Discount + Tax
	  Payment processed via Mobile Wallet


## Example test case 3 :
1. Run your compiled Java program (`Main`).
2. Follow the menu:
   - Select Order Type: `3` (Delivery)
   - Main Menu: `1` (Browse Menu Families)
   - Menu Family: `3` (Kids Menu)
   - Item Type: `3` (Dessert → Ice Cream Cup)
   - Customize: `6` (No more add-ons)
   - Quantity: `2`
   - Main Menu: `1` (Browse Families)
   - Menu Family: `3` (Kids Menu)
   - Item Type: `4` (Beverage → Chocolate Milk)
   - Customize: `6` (No more add-ons)
   - Quantity: `1`
   - Main Menu: `4` (Finish & Place Order)
   - Payment: `2` (Credit Card)

Expected: No discount (no pizza/meat/chicken special conditions)
	  Tax calculated correctly
	  Credit Card Strategy executes payment
	  Receipt printed cleanly

