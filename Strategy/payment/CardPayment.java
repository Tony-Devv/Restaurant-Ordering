package Strategy.payment;

public class CardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        // NOTE: In real app we'd call a gateway. Here we simulate success.
        System.out.printf("Charging card %s for $%.2f ... Approved.%n", mask(cardNumber), amount);
        return true;
    }

    private String mask(String card) {
        if (card == null || card.length() < 4) return "****";
        return "****-****-****-" + card.substring(card.length()-4);
    }

    @Override
    public String getName() {
        return "Credit Card";
    }
}
