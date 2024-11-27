import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = CarData.getPredefinedCars();

        System.out.println("Loaded Cars from Predefined Data:");
        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
