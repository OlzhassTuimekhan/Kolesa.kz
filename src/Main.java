import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = CarData.getPredefinedCars();

        carList.add(new Car.CarBuilder(3, "Honda", "Civic")
                .year(2018)
                .bodyType("SUV")
                .color("Blue")
                .engineVolume(2.0)
                .gearboxType("Automatic")
                .description("Sporty and stylish sedan.")
                .price(20000)
                .sellerPhone("+987654321")
                .build());

        // Выводим список автомобилей
        System.out.println("Loaded Cars from Predefined Data:");
        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
