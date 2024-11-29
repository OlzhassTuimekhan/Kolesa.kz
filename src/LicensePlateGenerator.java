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
    public String assignLicensePlate(String vinCode, List<Car> cars) {
        // Проверяем, существует ли машина с таким VIN-кодом
        Optional<Car> carOptional = cars.stream()
                .filter(car -> car.getVinCode().equalsIgnoreCase(vinCode))
                .findFirst();

        if (carOptional.isPresent()) {
            if (licensePlates.containsKey(vinCode)) {
                return "License plate already assigned: " + licensePlates.get(vinCode);
            }

            // Генерация госномера через текущую стратегию
            String licensePlate = strategy.generateLicensePlate();
            licensePlates.put(vinCode, licensePlate);
            return "License plate " + licensePlate + " assigned to car with VIN " + vinCode;
        } else {
            return "Car with VIN " + vinCode + " not found.";
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