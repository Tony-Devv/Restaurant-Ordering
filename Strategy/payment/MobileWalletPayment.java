package Strategy.payment;

public class MobileWalletPayment implements PaymentStrategy {
    private final String walletId;

    public MobileWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Processing Mobile Wallet (%s) payment of $%.2f ... Completed.%n", walletId, amount);
        return true;
    }

    @Override
    public String getName() {
        return "Mobile Wallet";
    }
}
