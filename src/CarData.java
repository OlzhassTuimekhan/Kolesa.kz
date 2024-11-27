import java.util.Arrays;
import java.util.List;

public class CarData {
    public static List<Car> getPredefinedCars() {
        return Arrays.asList(
                new Car.CarBuilder(1, "Toyota", "Corolla")
                        .year(2015)
                        .bodyType("Sedan")
                        .color("Black")
                        .engineVolume(1.8)
                        .gearboxType("Automatic")
                        .description("Reliable and fuel-efficient car.")
                        .price(8000)
                        .sellerPhone("+123456789")
                        .build(),
                new Car.CarBuilder(2, "Toyota", "Camry")
                        .year(2022)
                        .bodyType("Sedan")
                        .color("White")
                        .engineVolume(2.5)
                        .gearboxType("Automatic")
                        .description("Brand new car with full options.")
                        .price(30000)
                        .sellerPhone("+123456789")
                        .build()
        );
    }
}
