import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LicensePlateGenerator {
    private static Map<String, String> licensePlates = new HashMap<>();
    private LicensePlateStrategy strategy; // Стратегия для генерации

    public LicensePlateGenerator(LicensePlateStrategy strategy) {
        this.strategy = strategy; // Устанавливаем стратегию через конструктор
    }

    // Установка новой стратегии
    public void setStrategy(LicensePlateStrategy strategy) {
        this.strategy = strategy;
    }

    // Метод для назначения госномера по VIN-коду
    public String assignLicensePlateToOwnedCar(String vinCode, Account account) {
        // Проверяем, есть ли машина с этим VIN-кодом в коллекции купленных машин
        Optional<Car> carOptional = account.getOwnedCars().stream()
                .filter(car -> car.getVinCode().equalsIgnoreCase(vinCode))
                .findFirst();

        if (carOptional.isPresent()) {
            Car car = carOptional.get();

            if (licensePlates.containsKey(vinCode)) {
                return "License plate already assigned: " + licensePlates.get(vinCode);
            }

            // Генерация госномера через текущую стратегию
            String licensePlate = strategy.generateLicensePlate();
            licensePlates.put(vinCode, licensePlate);
            car.setLicensePlate(licensePlate); // Присваиваем номер машине
            return "License plate " + licensePlate + " assigned to your car with VIN " + vinCode;
        } else {
            return "No owned car with VIN " + vinCode + " found in your account.";
        }
    }

    // Метод для отображения всех госномеров
    public static void showAllLicensePlates() {
        if (licensePlates.isEmpty()) {
            System.out.println("No license plates assigned yet.");
        } else {
            licensePlates.forEach((vin, plate) ->
                    System.out.println("Car with VIN " + vin + " has license plate " + plate));
        }
    }
}