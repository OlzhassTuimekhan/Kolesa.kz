import java.util.List;
import java.util.ArrayList;

public class CarPurchaseMemento {
    private final List<Car> ownedCars;
    private final double balanceInKZT;

    public CarPurchaseMemento(List<Car> ownedCars, double balanceInKZT) {
        this.ownedCars = new ArrayList<>(ownedCars);
        this.balanceInKZT = balanceInKZT;
    }

    public List<Car> getOwnedCars() {
        return new ArrayList<>(ownedCars);
    }

    public double getBalanceInKZT() {
        return balanceInKZT;
    }
}