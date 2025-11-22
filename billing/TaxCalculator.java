package billing;

public class TaxCalculator {
    private final double taxRate; 

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

