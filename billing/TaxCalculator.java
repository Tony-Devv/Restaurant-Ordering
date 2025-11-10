package billing;

public class TaxCalculator {
    private final double taxRate; // e.g., 0.14 for 14%

    public TaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculateTax(double amount) {
        return amount * taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }
}
