
**Project: Kolesa.kz**

**Overview:**
This project demonstrates the implementation of various design patterns to manage and manipulate car-related data efficiently.
Key features include iteration through car collections, license plate generation, car data filtering, and state management.

Design Patterns Used:
1. Iterator Pattern:
   - Classes: CarIterator, FilteredCarIterator
   - Purpose: Provides a way to traverse through collections of cars without exposing their internal structure.

2. Strategy Pattern:
   - Classes: StandardLicensePlateStrategy, RegionalLicensePlateStrategy, LicensePlateStrategy
   - Purpose: Allows dynamic selection of different license plate generation algorithms.

3. Memento Pattern:
   - Classes: CarPurchaseMemento, CarPurchaseCaretaker
   - Purpose: Captures and restores the state of car purchase data.

4. Proxy Pattern:
   - Classes: CarDataProxy
   - Purpose: Provides controlled access to car data, adding a level of abstraction.

5. Observer Pattern:
   - Classes: Subject, Observer, Admin, BalanceManager
   - Purpose: Implements a subscription mechanism to notify multiple objects about events such as balance updates.

6. Builder Pattern:
   - Classes: Car, Car.Builder
   - Purpose: Constructs complex Car objects step by step, providing a flexible way to configure them.

7. Adapter Pattern:
   - Classes: CurrencyAdapter, CurrencyConverter
   - Purpose: Translates the interface of one class (CurrencyConverter) into a format compatible with another part of the system.

8. Singleton Pattern:
   - Classes: LicensePlateGenerator
   - Purpose: Ensures that a class has only one instance (e.g., a centralized license plate generator).

**Key Classes and Their Roles:**
1. CarIterator.java:
   - Defines the interface for the Iterator pattern.
   - Methods: hasNext(), next()

2. FilteredCarIterator.java:
   - Filters cars based on specific conditions while iterating.

3. Main.java:
   - Entry point of the application.
   - Demonstrates how various components interact.

4. LicensePlateStrategy and Its Implementations:
   - Provides algorithms for generating license plates based on different regional rules.

5. CarPurchaseMemento and Caretaker:
   - Facilitates the saving and restoring of car purchase states.

6. Subject and Observer:
   - Implements the Observer pattern for notifying users (e.g., Admin) when balances or states change.

7. Car.Builder:
   - Simplifies the creation of Car objects with customizable features.

8. CurrencyAdapter:
   - Adapts currency conversion functionality for system compatibility.

9. LicensePlateGenerator:
   - A Singleton class ensuring centralized license plate generation.

**Usage Instructions:**
- Run Main.java to start the application.
- Use the Builder to create new cars.
- Utilize the Adapter for currency conversion in transactions.
- Observe events (e.g., balance updates) using the Observer pattern.
- Manage car purchases with Memento for state saving/restoration.

**##Authors**
**- Olzhas Tuimekhan** [Backend Developer] 

**- Medet Muratbek** [Backend Developer]

**- Adilkhan Zharylapov** [Data Analyst]
