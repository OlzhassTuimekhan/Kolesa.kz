import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = CarData.getPredefinedCars();
        CurrencyConverter currencyAdapter = new CurrencyAdapter(); // Создаем адаптер для конвертации валют
        BalanceManager balanceManager = new BalanceManager(currencyAdapter); // Создаем менеджер баланса
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
                System.out.println("7. Link card");
                System.out.println("8. Check linked card");
                System.out.println("9. Show my transactions");
                System.out.println("10. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                System.out.println("----------------------------------------\n");
                scanner.nextLine(); // Очистить буфер

                if (choice < 1 || choice > 10) {
                    throw new IllegalArgumentException("Invalid menu option. Please choose a number between 1 and 10.");
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
                        balanceManager.showBalance(); // Отображение текущего баланса
                        break;
                    case 6:
                        addMoneyMenu(scanner, balanceManager); // Добавление денег
                        break;
                    case 7:
                        linkCardMenu(scanner, balanceManager); // Привязка карты
                        break;
                    case 8:
                        balanceManager.checkLinkedCard(); // Проверка привязанной карты
                        break;
                    case 9:
                        balanceManager.showTransactions(); // Показать историю транзакций
                        break;
                    case 10:
                        System.out.println("Exiting. Goodbye!");
                        return;
                    default:
                        System.out.println("Unexpected error.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                scanner.nextLine(); // Очистить буфер
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
                System.out.println("4. Search by VINCODE");
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
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            scanner.nextLine(); // Очистить буфер
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addMoneyMenu(Scanner scanner, BalanceManager balanceManager) {
        if (!balanceManager.isCardLinked()) {
            System.out.println("You must link a card before adding money.");
            return;
        }
        try {
            System.out.print("Enter currency (USD, EUR, RUB, KZT): ");
            String currency = scanner.nextLine().toUpperCase();
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Очистить буфер
            balanceManager.addMoney(currency, amount);
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
            scanner.nextLine(); // Очистить буфер
        }
    }

    private static void linkCardMenu(Scanner scanner, BalanceManager balanceManager) {
        System.out.print("Enter a 16-digit card number: ");
        String cardNumber = scanner.nextLine();
        balanceManager.linkCard(cardNumber);
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