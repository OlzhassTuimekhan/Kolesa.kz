import java.util.ArrayList;
import java.util.List;

public class Account {
    private final BalanceManager balanceManager; // Управление балансом
    private final List<Car> ownedCars; // Список приобретённых машин

    public Account(BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
        this.ownedCars = new ArrayList<>();
    }

    // Добавить машину в список
    public void addCar(Car car) {
        ownedCars.add(car);
    }

    // Показать информацию об аккаунте
    public void showAccountDetails() {
        System.out.println("\n--- My Account ---");
        balanceManager.showBalance(); // Показать баланс
        balanceManager.checkLinkedCard(); // Показать номер карты

        if (ownedCars.isEmpty()) {
            System.out.println("You do not own any cars.");
        } else {
            System.out.println("Your Cars:");
            for (Car car : ownedCars) {
                System.out.println(car); // Используем метод toString() для вывода машины
            }
        }
    }
}