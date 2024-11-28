import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

class FilteredCarIterator implements CarIterator {
    private final List<Car> cars;
    private final Predicate<Car> filter;
    private int currentIndex = 0;

    public FilteredCarIterator(List<Car> cars, Predicate<Car> filter) {
        this.cars = cars;
        this.filter = filter;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < cars.size()) {
            if (filter.test(cars.get(currentIndex))) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Car next() {
        return cars.get(currentIndex++);
    }
}



// Основной класс программы
class mainn {
    public static void main(String[] args) {
        List<Car> cars = CarData.getPredefinedCars();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Management System with Iterator!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search By Brand");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("\nEnter brand: ");
                String brand = scanner.nextLine();

                // Используем итератор для поиска
                CarIterator iterator = new FilteredCarIterator(cars, car -> car.getBrand().equalsIgnoreCase(brand));
                System.out.println("\nSearch Results:");
                boolean found = false;
                while (iterator.hasNext()) {
                    found = true;
                    System.out.println(iterator.next());
                }
                if (!found) {
                    System.out.println("No cars found for the given brand.");
                }
            } else if (choice == 2) {
                System.out.println("Exiting. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}