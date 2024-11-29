import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
//// medet
    public static void main(String[] args) {
        List<Car> cars = CarData.getPredefinedCars();
        CurrencyConverter currencyAdapter = new CurrencyAdapter();
        BalanceManager balanceManager = new BalanceManager(currencyAdapter);
        Account account = new Account(balanceManager); // Создаем аккаунт
        CarPurchaseCaretaker caretaker = new CarPurchaseCaretaker();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Car Management System!");
        //
        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Show cars");
                System.out.println("2. Add cars for selling");
                System.out.println("3. Generate a license plate");
                System.out.println("4. Show my account");
                System.out.println("5. Add money");
                System.out.println("6. Link card");
                System.out.println("7. Show my transactions");
                System.out.println("8. Buy Car");
                System.out.println("9. Undo Last Purchase");
                System.out.println("10. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                System.out.println("----------------------------------------\n");
                scanner.nextLine(); // Clear buffer

                if (choice < 1 || choice > 9) {
                    throw new IllegalArgumentException("Invalid menu option. Please choose a number between 1 and 9.");
                }

                switch (choice) {
                    case 1:
                        showCarsMenu(scanner, cars);
                        break;
                    case 2:
                        addCar(scanner, cars);
                        break;
                    case 3:
                        System.out.println("Choose license plate generation strategy:");
                        System.out.println("1. Standard");
                        System.out.println("2. Regional");
                        int strategyChoice = scanner.nextInt();
                        scanner.nextLine(); // Очистка буфера

                        LicensePlateStrategy strategy;
                        if (strategyChoice == 1) {
                            strategy = new StandardLicensePlateStrategy();
                        } else if (strategyChoice == 2) {
                            System.out.print("Enter region code (e.g., 18): ");
                            String region = scanner.nextLine();
                            strategy = new RegionalLicensePlateStrategy(region);
                        } else {
                            System.out.println("Invalid choice. Using default strategy.");
                            strategy = new StandardLicensePlateStrategy();
                        }

                        LicensePlateGenerator generator = new LicensePlateGenerator(strategy);
                        System.out.print("Enter VIN Code to generate license plate: ");
                        String vinCode = scanner.nextLine();
                        String result = generator.assignLicensePlate(vinCode, cars);
                        System.out.println(result);
                        break;
                    case 4:
                        account.showAccountDetails(); // Показать аккаунт
                        break;
                    case 5:
                        addMoneyMenu(scanner, balanceManager);
                        break;
                    case 6:
                        linkCardMenu(scanner, balanceManager);
                        break;
                    case 7:
                        balanceManager.showTransactions();
                        break;
                    case 8:
                        buyCarMenu(scanner, cars, account, balanceManager, caretaker);
                        break;
                    case 9:
                        undoPurchaseMenu(account, caretaker);
                        break;
                    case 10:
                        System.out.println("Exiting. Goodbye!");
                        return;
                    default:
                        System.out.println("Unexpected error.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
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
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            scanner.nextLine(); // Clear buffer to avoid infinite loop
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
            scanner.nextLine(); // Clear buffer
            balanceManager.addMoney(currency, amount);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear buffer
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

    private static void linkCardMenu(Scanner scanner, BalanceManager balanceManager) {
        System.out.print("Enter a 16-digit card number: ");
        String cardNumber = scanner.nextLine();
        balanceManager.linkCard(cardNumber);
    }

    private static void addCar(Scanner scanner, List<Car> cars) {
        System.out.println("\nAdd a New Car");
        int id = 61;
        try {

            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();

            System.out.print("Enter Model: ");
            String model = scanner.nextLine();

            System.out.print("Enter Year: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            System.out.print("Enter Body Type: ");
            String bodyType = scanner.nextLine();

            System.out.print("Enter Color: ");
            String color = scanner.nextLine();

            System.out.print("Enter Engine Volume (e.g., 2.0): ");
            double engineVolume = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            System.out.print("Enter Gearbox Type: ");
            String gearboxType = scanner.nextLine();

            System.out.print("Enter Description: ");
            String description = scanner.nextLine();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            System.out.print("Enter Seller Phone: ");
            String sellerPhone = scanner.nextLine();

            System.out.print("Enter VIN Code: ");
            String vinCode = scanner.nextLine();

            Car newCar = new Car.CarBuilder(id, brand, model)
                    .year(year)
                    .bodyType(bodyType)
                    .color(color)
                    .engineVolume(engineVolume)
                    .gearboxType(gearboxType)
                    .description(description)
                    .price(price)
                    .sellerPhone(sellerPhone)
                    .vinCode(vinCode)
                    .build();
            id++;
            cars.add(newCar);

            System.out.println("\nYour ad has been successfully added");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear buffer
        }
    }

    private static void buyCarMenu(Scanner scanner, List<Car> cars, Account account, BalanceManager balanceManager, CarPurchaseCaretaker caretaker) {
        System.out.print("Enter VINCODE of the car you want to buy: ");
        String vin = scanner.nextLine();

        Car carToBuy = cars.stream()
                .filter(car -> car.getVinCode().equalsIgnoreCase(vin))
                .findFirst()
                .orElse(null);

        if (carToBuy == null) {
            System.out.println("Car with VINCODE " + vin + " not found.");
            return;
        }

        if (carToBuy.getPrice() > balanceManager.getBalanceInKZT()) {
            System.out.println("Insufficient funds to buy this car.");
            return;
        }

        // Сохранить состояние перед покупкой
        caretaker.saveState(account.saveState());

        balanceManager.addMoney("KZT", -carToBuy.getPrice()); // Списание денег
        account.addCar(carToBuy); // Добавляем машину в аккаунт
        System.out.println("Successfully purchased the car: " + carToBuy);
    }

    private static void undoPurchaseMenu(Account account, CarPurchaseCaretaker caretaker) {
        if (!caretaker.hasUndo()) {
            System.out.println("No purchase to undo.");
            return;
        }
        account.restoreState(caretaker.undoState());
        System.out.println("Purchase successfully undone.");
    }


}