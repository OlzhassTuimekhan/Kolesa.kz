import java.util.List;

public class CarDataProxy {
    private List<Car> cachedCars; // Кэш
    private final CarData carData = new CarData(); // Основной источник данных

    public List<Car> getPredefinedCars() {
        if (cachedCars == null) {
            System.out.println("Cache is empty. Fetching data from DataBase...");
            cachedCars = carData.getPredefinedCars();
        } else {
            System.out.println("Returning cars from cache...");
        }
        return cachedCars;
    }

    public void clearCache() {
        cachedCars = null;
        System.out.println("Cache cleared.");
    }
}
