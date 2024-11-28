import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (choice < 1 || choice > 8) {
                    throw new IllegalArgumentException("Invalid menu option. Please choose a number between 1 and 8.");
                }
d
                switch (choice) {
                    case 1:
                        showCarsMenu(scanner);
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

    private static void showCarsMenu(Scanner scanner) {
        try {
            System.out.println("\nCar Search:");
            System.out.println("1. Search by Brand");
            System.out.println("2. Search by Year");
            System.out.println("3. Search by Price");
            System.out.println("4. Search by Brand and Model");
            System.out.print("Choose an option: ");

            int searchChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (searchChoice < 1 || searchChoice > 4) {
                throw new IllegalArgumentException("Invalid search option. Please choose a number between 1 and 4.");
            }

            switch (searchChoice) {
                case 1:
                    System.out.println("Search by Brand will be implemented in the future.");
                    break;
                case 2:
                    System.out.println("Search by Year will be implemented in the future.");
                    break;
                case 3:
                    System.out.println("Search by Price will be implemented in the future.");
                    break;
                case 4:
                    System.out.println("Search by Brand and Model will be implemented in the future.");
                    break;
                default:
                    System.out.println("Unexpected error.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            scanner.nextLine(); // Clear buffer to avoid infinite loop
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}