import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LicensePlateGenerator {
    private static Map<String, String> licensePlates = new HashMap<>();
    private LicensePlateStrategy strategy;

    public LicensePlateGenerator(LicensePlateStrategy strategy) {
        this.strategy = strategy;
    }

    //Sets Strategy Pattern
    public void setStrategy(LicensePlateStrategy strategy) {
        this.strategy = strategy;
    }

    public String assignLicensePlateToOwnedCar(String vinCode, Account account) {

        Optional<Car> carOptional = account.getOwnedCars().stream()
                .filter(car -> car.getVinCode().equalsIgnoreCase(vinCode))
                .findFirst();

        if (carOptional.isPresent()) {
            Car car = carOptional.get();

            if (licensePlates.containsKey(vinCode)) {
                return "License plate already assigned: " + licensePlates.get(vinCode);
            }


            String licensePlate = strategy.generateLicensePlate();
            licensePlates.put(vinCode, licensePlate);
            car.setLicensePlate(licensePlate);
            return "License plate " + licensePlate + " assigned to your car with VIN " + vinCode;
        } else {
            return "No owned car with VIN " + vinCode + " found in your account.";
        }
    }

    public static void showAllLicensePlates() {
        if (licensePlates.isEmpty()) {
            System.out.println("No license plates assigned yet.");
        } else {
            licensePlates.forEach((vin, plate) ->
                    System.out.println("Car with VIN " + vin + " has license plate " + plate));
        }
    }
}