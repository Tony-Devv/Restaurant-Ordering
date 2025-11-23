# Restaurant Ordering & Billing System

## Course Information
- **University**: Cairo University - Faculty of Computers and Artificial Intelligence
- **Course**: Advanced Software Engineering 2025
- **Team**: Anton & Hatem
- **TA**: Ta Marwa Or Ta Mostafa

## Design Patterns Implemented

1. **Facade Pattern** - `RestaurantFacade.java` provides unified interface for ordering workflow
2. **Abstract Factory Pattern** - Creates menu families (Vegetarian, Non-Vegetarian, Kids)
3. **Factory Method Pattern** - Creates specific items (Italian Pizza, Eastern Pizza, Burgers)
4. **Decorator Pattern** - Adds customizable add-ons to menu items
5. **Observer Pattern** - Notifies kitchen and waiter when orders are placed
6. **Strategy Pattern (Payment)** - Supports Cash, Card, and Mobile Wallet payments
7. **Strategy Pattern (Discount)** - Applies category-based discounts

**For detailed design rationale, see `src/DOCUMENTATION.txt`**

## Project Structure
```
src/
├── Main.java
├── DOCUMENTATION.txt
├── model/                       (MenuItem interface + base classes)
├── factory/
│   ├── abstractfactory/        (3 menu factories)
│   └── factorymethod/          (Pizza & Burger factories)
├── decorator/                   (5 add-on decorators)
├── observer/                    (Kitchen & Waiter notification)
├── facade/                      (RestaurantFacade)
├── billing/                     (BillingService, Bill, TaxCalculator)
└── Strategy/
    ├── payment/                (3 payment strategies)
    └── discount/               (4 discount strategies + factory)
```

## How to Run the Project

### Prerequisites
- Java JDK 8 or higher

### Compilation
```bash
cd src
javac Main.java
```

### Execution
```bash
java Main
```

## Example Test Cases

### Test Case 1: Pizza Order with Customization & Discount
**Scenario**: Order 2 Italian Margherita pizzas with add-ons

**Input**:
```
1 (Dine-in)
2 (Order Pizza)
1 (Italian Pizza)
Margherita
1 (Extra Cheese)
2 (Mushrooms)
6 (Done customizing)
2 (Quantity: 2)
4 (Finish Order)
1 (Cash Payment)
```

**Expected Output**:
```
Items: Italian Margherita Pizza, Extra Cheese, Mushrooms × 2
Subtotal: $260.00 (Base: $95, +$15 cheese, +$20 mushrooms = $130 × 2)
Discount: -$26.00 (10% Pizza Discount applied)
Tax (14%): $32.76
Total: $266.76
Kitchen & Waiter notified
```

---

### Test Case 2: Meat Order with Fixed Discount
**Scenario**: Order 2 Beef Burgers

**Input**:
```
1 (Dine-in)
3 (Order Burger)
Beef
6 (No add-ons)
2 (Quantity: 2)
4 (Finish Order)
2 (Card Payment)
4111111111111111 (Card number)
```

**Expected Output**:
```
Items: Classic Beef Burger × 2
Subtotal: $220.00 ($110 × 2)
Discount: -$14.00 ($7 per Meat item × 2)
Tax (14%): $28.84
Total: $234.84
Payment via Credit Card
```

---

### Test Case 3: No Discount Scenario
**Scenario**: Order desserts and beverages (no eligible discount category)

**Input**:
```
1 (Dine-in)
1 (Browse Menu Families)
3 (Kids Menu)
3 (Dessert)
6 (No add-ons)
2 (Quantity: 2)
1 (Browse Menu Families)
3 (Kids Menu)
4 (Beverage)
6 (No add-ons)
1 (Quantity: 1)
4 (Finish Order)
1 (Cash Payment)
```

**Expected Output**:
```
Items: Ice Cream Sundae × 2, Chocolate Milk × 1
Subtotal: $88.00 ($35×2 + $18×1)
Discount: $0.00 (No Discount applied)
Tax (14%): $12.32
Total: $100.32
```

## Discount Scenarios

### Available Discount Strategies

The system automatically selects the best discount based on order contents (Priority-based):

| Priority | Category | Discount Type | Discount Amount |
|----------|----------|---------------|-----------------|
| 1 (Highest) | Pizza | Percentage | 10% off pizza items |
| 2 | Chicken | Percentage | 8% off chicken items |
| 3 | Meat | Fixed | $7.00 off per meat item |
| 4 (Default) | Other | None | No discount |

### Discount Examples

1. **Pizza Discount (10%)**
   - Order contains: Pizza items
   - Calculation: 10% of total pizza price
   - Example: $200 pizza → $20 discount

2. **Chicken Discount (8%)**
   - Order contains: Chicken items (no pizza)
   - Calculation: 8% of total chicken price
   - Example: $150 chicken → $12 discount

3. **Meat Discount ($7/item)**
   - Order contains: Meat items (no pizza/chicken)
   - Calculation: $7 fixed per meat item
   - Example: 3 beef burgers → $21 discount ($7 × 3)

4. **No Discount**
   - Order contains: Only desserts/beverages/veggie items
   - No discount applied

### Priority Rule
If an order contains multiple categories, only the **highest priority** discount applies:
- Pizza + Chicken → Pizza discount (10%)
- Chicken + Meat → Chicken discount (8%)
- Meat only → Meat discount ($7/item)
