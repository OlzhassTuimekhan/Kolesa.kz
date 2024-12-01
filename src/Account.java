import java.util.List;
import java.util.ArrayList;

public class Account {
    private static Account instance;
    private final BalanceManager balanceManager;
    private final List<Car> ownedCars;


    Account(BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
        this.ownedCars = new ArrayList<>();
    }


    public static Account getInstance(BalanceManager balanceManager) {
        if (instance == null) {
            instance = new Account(balanceManager);
        }
        return instance;
    }


    public void addCar(Car car) {
        ownedCars.add(car);
    }


    public void removeCar(Car car) {
        ownedCars.remove(car);
    }

    public List<Car> getOwnedCars() {
        return new ArrayList<>(ownedCars);
    }

    //Memento Pattern
    public CarPurchaseMemento saveState() {
        return new CarPurchaseMemento(ownedCars, balanceManager.getBalanceInKZT());
    }


    public void restoreState(CarPurchaseMemento memento) {
        if (memento != null) {
            ownedCars.clear();
            ownedCars.addAll(memento.getOwnedCars());
            balanceManager.setBalanceInKZT(memento.getBalanceInKZT());
        }
    }


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
