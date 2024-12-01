import java.util.ArrayList;
import java.util.List;

public class BalanceManager {
    private double balanceInKZT;
    private final CurrencyConverter currencyConverter;
    private String linkedCard;
    private final List<String> transactions;

    public BalanceManager(CurrencyConverter currencyConverter) {
        this.balanceInKZT = 0.0;
        this.currencyConverter = currencyConverter;
        this.linkedCard = null;
        this.transactions = new ArrayList<>();
    }


    public void linkCard(String cardNumber) {
        if (cardNumber.matches("\\d{16}")) {
            this.linkedCard = cardNumber;
            System.out.println("Card linked successfully: ** ** **** " + cardNumber.substring(12));
        } else {
            System.out.println("Invalid card number. Please enter a valid 16-digit card number.");
        }
    }


    public boolean isCardLinked() {
        return linkedCard != null;
    }


    public void addMoney(String currency, double amount) {
        if (amount == 0) {
            System.out.println("Amount must be non-zero.");
            return;
        }

        if (amount < 0 && Math.abs(amount) > balanceInKZT) {
            System.out.println("Insufficient funds for this operation.");
            return;
        }

        try {
            double amountInKZT = currencyConverter.convertToKZT(currency, amount);
            balanceInKZT += amountInKZT;
            String transactionType = amount > 0 ? "Added: " : "Deducted: ";
            transactions.add(transactionType + Math.abs(amount) + " " + currency + " (converted to " + amountInKZT + " KZT)");
            System.out.println(transactionType + Math.abs(amount) + " " + currency + " (converted to " + amountInKZT + " KZT).");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public void showBalance() {
        System.out.println("\nCurrent Balance in KZT: " + balanceInKZT);
    }

    public double getBalanceInKZT() {
        return balanceInKZT;
    }

    public void setBalanceInKZT(double balanceInKZT) {
        this.balanceInKZT = balanceInKZT;
    }




    public void checkLinkedCard() {
        if (linkedCard == null) {
            System.out.println("No card is linked.");
        } else {
            System.out.println("Linked card: ** ** **** " + linkedCard.substring(12));
        }
    }


    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        System.out.println("\nTransaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}