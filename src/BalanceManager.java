import java.util.ArrayList;
import java.util.List;

public class BalanceManager {
    private double balanceInKZT; // Баланс хранится в KZT
    private final CurrencyConverter currencyConverter;
    private String linkedCard; // Привязанный номер карты
    private final List<String> transactions; // История транзакций

    public BalanceManager(CurrencyConverter currencyConverter) {
        this.balanceInKZT = 0.0;
        this.currencyConverter = currencyConverter;
        this.linkedCard = null;
        this.transactions = new ArrayList<>();
    }

    // Привязка карты
    public void linkCard(String cardNumber) {
        if (cardNumber.matches("\\d{16}")) { // Проверяем, что карта состоит из 16 цифр
            this.linkedCard = cardNumber;
            System.out.println("Card linked successfully: ** ** **** " + cardNumber.substring(12));
        } else {
            System.out.println("Invalid card number. Please enter a valid 16-digit card number.");
        }
    }

    // Проверка, привязана ли карта
    public boolean isCardLinked() {
        return linkedCard != null;
    }

    // Добавление денег
    public void addMoney(String currency, double amount) {
        if (!isCardLinked()) { // Проверка, привязана ли карта
            System.out.println("You must link a card before adding money.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }
        try {
            double amountInKZT = currencyConverter.convertToKZT(currency, amount);
            balanceInKZT += amountInKZT;
            transactions.add("Added: " + amount + " " + currency + " (converted to " + amountInKZT + " KZT)");
            System.out.println("Added " + amount + " " + currency + " (converted to " + amountInKZT + " KZT) to your balance.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Показать текущий баланс
    public void showBalance() {
        System.out.println("\nCurrent Balance in KZT: " + balanceInKZT);
    }

    // Проверка привязанной карты
    public void checkLinkedCard() {
        if (linkedCard == null) {
            System.out.println("No card is linked.");
        } else {
            System.out.println("Linked card: ** ** **** " + linkedCard.substring(12));
        }
    }

    // Отображение истории транзакций
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