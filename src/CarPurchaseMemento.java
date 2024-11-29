import java.util.List;
import java.util.ArrayList;

public class CarPurchaseMemento {
    private final List<Car> ownedCars; // Список купленных машин
    private final double balanceInKZT; // Баланс на момент сохранения

    public CarPurchaseMemento(List<Car> ownedCars, double balanceInKZT) {
        this.ownedCars = new ArrayList<>(ownedCars); // Копия списка машин
        this.balanceInKZT = balanceInKZT;
    }

    public List<Car> getOwnedCars() {
        return new ArrayList<>(ownedCars);
    }

    public double getBalanceInKZT() {
        return balanceInKZT;
    }
}