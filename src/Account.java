import java.util.List;
import java.util.ArrayList;

public class Account {
    private static Account instance; // Единственный экземпляр
    private final BalanceManager balanceManager; // Управление балансом
    private final List<Car> ownedCars; // Список приобретённых машин

    // Приватный конструктор для предотвращения создания экземпляров извне
    Account(BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
        this.ownedCars = new ArrayList<>();
    }

    // Метод для получения единственного экземпляра
    public static Account getInstance(BalanceManager balanceManager) {
        if (instance == null) {
            instance = new Account(balanceManager);
        }
        return instance;
    }

    // Добавить машину в список
    public void addCar(Car car) {
        ownedCars.add(car);
    }

    // Удалить машину из списка
    public void removeCar(Car car) {
        ownedCars.remove(car);
    }

    public List<Car> getOwnedCars() {
        return new ArrayList<>(ownedCars); // Возвращаем копию списка машин
    }

    // Создать снимок состояния
    public CarPurchaseMemento saveState() {
        return new CarPurchaseMemento(ownedCars, balanceManager.getBalanceInKZT());
    }

    // Восстановить состояние
    public void restoreState(CarPurchaseMemento memento) {
        if (memento != null) {
            ownedCars.clear();
            ownedCars.addAll(memento.getOwnedCars());
            balanceManager.setBalanceInKZT(memento.getBalanceInKZT());
        }
    }

    // Показать информацию об аккаунте
    public void showAccountDetails() {
        System.out.println("\n--- My Account ---");
        balanceManager.showBalance();
        balanceManager.checkLinkedCard();

        if (ownedCars.isEmpty()) {
            System.out.println("You do not own any cars.");
        } else {
            System.out.println("Your Cars:");
            for (Car car : ownedCars) {
                System.out.println(car);
            }
        }
    }
}
