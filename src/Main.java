// Car Management System
// Muratbek Medet ID:230103176
// Zharylkapov Adilkhan ID:230103198
// Olzhas Tuimekhan ID:230103030

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Proxy Pattern: Used to fetch predefined car data
        CarDataProxy carDataProxy = new CarDataProxy();
        List<Car> cars = carDataProxy.getPredefinedCars(); // Retrieve predefined cars

        // Adapter Pattern: Currency conversion for adding balance
        CurrencyConverter currencyAdapter = new CurrencyAdapter();
        BalanceManager balanceManager = new BalanceManager(currencyAdapter); // Handles balance and transactions

        // Observer Pattern: Observing balance changes through BalanceManager
        Account account = new Account(balanceManager); // Creates a user account

        // Memento Pattern: Used to save and restore account states
        CarPurchaseCaretaker caretaker = new CarPurchaseCaretaker();

        // Singleton and Strategy Patterns: LicensePlateGenerator with dynamic strategies
        LicensePlateGenerator generator = new LicensePlateGenerator(new StandardLicensePlateStrategy());

        // Singleton Pattern: Ensures only one instance of ChatServer
        ChatServer chatServer = ChatServer.getInstance();
        new Thread(chatServer::startServer).start(); // Starts the server in a separate thread

        // Welcome message and scanner for input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Car Management System!");

        // Main menu loop
        while (true) {
            try {
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("▐ Menu:                              ▐");
                System.out.println("▐ 1. Show cars                       ▐");
                System.out.println("▐ 2. Add Car                         ▐");
                System.out.println("▐ 3. Generate a license plate        ▐");
                System.out.println("▐ 4. My Account                      ▐");
                System.out.println("▐ 5. Add money                       ▐");
                System.out.println("▐ 6. Link card                       ▐");
                System.out.println("▐ 7. Show my transactions            ▐");
                System.out.println("▐ 8. Buy Car                         ▐");
                System.out.println("▐ 9. Undo Last Purchase              ▐");
                System.out.println("▐ 10. Exit                           ▐");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.print(" Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the scanner buffer

                // Validate menu choice
                if (choice < 1 || choice > 10) {
                    throw new IllegalArgumentException("Invalid menu option. Please choose a number between 1 and 10.");
                }

                // Handle menu choices
                switch (choice) {
                    case 1:
                        showCarsMenu(scanner, cars); // Display cars
                        break;
                    case 2:
                        addCar(scanner, cars, chatServer); // Add a new car
                        break;
                    case 3:
                        licensePlate(scanner, generator, account); // Generate a license plate
                        break;
                    case 4:
                        account.showAccountDetails(); // Show account details
                        break;
                    case 5:
                        addMoneyMenu(scanner, balanceManager); // Add money to the account
                        break;
                    case 6:
                        linkCardMenu(scanner, balanceManager); // Link a payment card
                        break;
                    case 7:
                        balanceManager.showTransactions(); // Show transaction history
                        break;
                    case 8:
                        buyCarMenu(scanner, cars, account, balanceManager, caretaker); // Buy a car
                        break;
                    case 9:
                        undoPurchaseMenu(account, caretaker); // Undo last purchase
                        break;
                    case 10:
                        System.out.println("Good Bye!"); // Exit the application
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                scanner.nextLine(); // Clear scanner buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Sub-menu to display cars
    private static void showCarsMenu(Scanner scanner, List<Car> cars) {
        try {
            boolean sh = true;
            while (sh) {
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("Car Search:");
                System.out.println("1. Show all cars");
                System.out.println("2. Search by Brand");
                System.out.println("3. Search by Year");
                System.out.println("4. Search by Price");
                System.out.println("5. Search by VINCODE");
                System.out.println("6. Go to Previous Menu.");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear scanner buffer

                // Handle different search criteria
                switch (choice) {
                    case 1:
                        if (cars.isEmpty()) {
                            System.out.println("No cars found.");
                        } else {
                            for (Car car : cars) {
                                System.out.println(car.toString());
                            }
                        }
                        break;
                    case 2:
                        System.out.print("\nEnter brand: ");
                        String brand = scanner.nextLine();
                        CarIterator brandIterator = new FilteredCarIterator(cars, car -> car.getBrand().equalsIgnoreCase(brand));
                        displayResults(brandIterator); // Display filtered cars
                        break;
                    case 3:
                        System.out.print("\nEnter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        CarIterator yearIterator = new FilteredCarIterator(cars, car -> car.getYear() == year);
                        displayResults(yearIterator); // Display cars by year
                        break;
                    case 4:
                        System.out.print("\nEnter minimum price: ");
                        double minPrice = scanner.nextDouble();
                        System.out.print("Enter maximum price: ");
                        double maxPrice = scanner.nextDouble();
                        scanner.nextLine();
                        CarIterator priceIterator = new FilteredCarIterator(cars, car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice);
                        displayResults(priceIterator); // Display cars by price range
                        break;
                    case 5:
                        System.out.print("\nEnter VINCODE: ");
                        String vin = scanner.nextLine();
                        CarIterator vinIterator = new FilteredCarIterator(cars, car -> car.getVinCode().equalsIgnoreCase(vin));
                        displayResults(vinIterator); // Display cars by VIN
                        break;
                    case 6:
                        sh = false; // Exit the car search menu
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 6.");
            scanner.nextLine(); // Clear scanner buffer
        }
    }

    // Method to display search results
    private static void displayResults(CarIterator iterator) {
        System.out.println("\nSearch Results:");
        boolean found = false;
        while (iterator.hasNext()) {
            Car car = iterator.next();
            found = true;
            if (car.isSold()) {
                System.out.println(car + "\nStatus: SOLD");
            } else {
                System.out.println(car + "\nStatus: AVAILABLE");
            }
        }
        if (!found) {
            System.out.println("No cars found for the given criteria.");
        }
    }

    // Menu for adding money
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

    // Menu for linking a card
    private static void linkCardMenu(Scanner scanner, BalanceManager balanceManager) {
        System.out.print("Enter a 16-digit card number: ");
        String cardNumber = scanner.nextLine();
        balanceManager.linkCard(cardNumber);
    }

    // Menu to add a new car
    private static void addCar(Scanner scanner, List<Car> cars, ChatServer chatServer) {
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
            chatServer.broadcastMessageFromAdmin("A new car has been added.\n" + newCar.getBrand() + " " + newCar.getModel() + ", " + newCar.getYear());

            System.out.println("\nYour ad has been successfully added");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear buffer
        }
    }

    // Menu for buying a car
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

        caretaker.saveState(account.saveState()); // Save current state

        balanceManager.addMoney("KZT", -carToBuy.getPrice()); // Deduct price from balance
        account.addCar(carToBuy); // Add car to user's account
        carToBuy.setSold(true); // Mark car as sold
        System.out.println("Successfully purchased the car: \n" + carToBuy);
    }

    // Menu to undo the last car purchase
    private static void undoPurchaseMenu(Account account, CarPurchaseCaretaker caretaker) {
        if (!caretaker.hasUndo()) {
            System.out.println("No purchase to undo.");
            return;
        }
        account.restoreState(caretaker.undoState()); // Restore the previous state
        System.out.println("Purchase successfully undone.");
    }

    // Menu for generating a license plate
    public static void licensePlate(Scanner scanner, LicensePlateGenerator generator, Account account) {
        System.out.println("Choose license plate generation strategy:");
        System.out.println("1. Standard");
        System.out.println("2. Regional");
        int strategyChoice = scanner.nextInt();
        scanner.nextLine();

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

        generator.setStrategy(strategy); // Set the chosen strategy

        System.out.print("Enter VIN Code of your owned car to generate license plate: ");
        String vinCode = scanner.nextLine();

        String result = generator.assignLicensePlateToOwnedCar(vinCode, account); // Generate the license plate
        System.out.println(result);
    }
}