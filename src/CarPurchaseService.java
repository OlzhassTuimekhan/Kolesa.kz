public class CarPurchaseService {
    public void buyCar(Car car) {
        if (!car.isSold()) {
            String licensePlate = LicensePlateGenerator.generateLicensePlate();
            car.setSold(true); // Устанавливаем статус "продано"
            System.out.println("Car " + car.getId() + " has been sold!");
            System.out.println("Generated License Plate: " + licensePlate);
        } else {
            System.out.println("Car " + car.getId() + " is already sold.");
        }
    }
}