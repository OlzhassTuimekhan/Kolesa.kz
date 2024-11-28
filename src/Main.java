import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = CarData.getPredefinedCars();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Car Management System!");

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Show cars");
                System.out.println("2. Add cars for selling");
                System.out.println("3. Generate a license plate");
                System.out.println("4. Show my cars");
                System.out.println("5. Show my balance");
                System.out.println("6. Add money");
                System.out.println("7. Show my transactions");
                System.out.println("8. Buy Car");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (choice < 1 || choice > 8) {
                    throw new IllegalArgumentException("Invalid menu option. Please choose a number between 1 and 8.");
                }

                switch (choice) {
                    case 1:
                        showCarsMenu(scanner, cars);
                        break;
                    case 2:
                        System.out.println("Adding cars for selling will be implemented in the future.");
                        break;
                    case 3:
                        System.out.println("Generating a license plate will be implemented in the future.");
                        break;
                    case 4:
                        System.out.println("Showing my cars will be implemented in the future.");
                        break;
                    case 5:
                        System.out.println("Showing my balance will be implemented in the future.");
                        break;
                    case 6:
                        System.out.println("Adding money will be implemented in the future.");
                        break;
                    case 7:
                        System.out.println("Showing my transactions will be implemented in the future.");
                        break;
                    case 8:
                        System.out.println("For buying ENTER VINCODE");
                        return;
                    case 9:
                        System.out.println("Exiting. Goodbye!");
                        return;
                    default:
                        System.out.println("Unexpected error.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine(); // Clear buffer to avoid infinite loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void showCarsMenu(Scanner scanner, List<Car> cars) {
        try {
            boolean sh = true;
            while (sh) {
                System.out.println("\nCar Search:");
                System.out.println("1. Search by Brand");
                System.out.println("2. Search by Year");
                System.out.println("3. Search by Price");
                System.out.println("4. Search by VINCODE ");
                System.out.println("5. Go to Previous Menu.");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("\nEnter brand: ");
                        String brand = scanner.nextLine();
                        CarIterator brandIterator = new FilteredCarIterator(cars, car -> car.getBrand().equalsIgnoreCase(brand));
                        displayResults(brandIterator);
                        break;

                    case 2:
                        System.out.print("\nEnter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        CarIterator yearIterator = new FilteredCarIterator(cars, car -> car.getYear() == year);
                        displayResults(yearIterator);
                        break;

                    case 3:
                        System.out.print("\nEnter minimum price: ");
                        double minPrice = scanner.nextDouble();
                        System.out.print("Enter maximum price: ");
                        double maxPrice = scanner.nextDouble();
                        scanner.nextLine();
                        CarIterator priceIterator = new FilteredCarIterator(cars, car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice);
                        displayResults(priceIterator);
                        break;

                    case 4:
                        System.out.print("\nEnter VINCODE: ");
                        String vin = scanner.nextLine();
                        CarIterator vinIterator = new FilteredCarIterator(cars, car -> car.getVinCode().equalsIgnoreCase(vin));
                        displayResults(vinIterator);
                        break;
                    case 5:
                        sh = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            scanner.nextLine(); // Clear buffer to avoid infinite loop
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayResults(CarIterator iterator) {
        System.out.println("\nSearch Results:");
        boolean found = false;
        while (iterator.hasNext()) {
            found = true;
            System.out.println(iterator.next());
        }
        if (!found) {
            System.out.println("No cars found for the given criteria.");
        }
    }


}