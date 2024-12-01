import java.util.List;
import java.util.function.Predicate;

/**
 * A filtered implementation of the CarIterator interface.
 * Allows iteration over a collection of Car objects that match a specified filter condition.
 */
class FilteredCarIterator implements CarIterator {
    private final List<Car> cars; // List of cars to be filtered
    private final Predicate<Car> filter; // Filter condition for cars
    private int currentIndex = 0; // Current index in the list

    /**
     * Constructor to initialize the filtered iterator with a list of cars and a filter condition.
     * @param cars   The list of cars to iterate over.
     * @param filter The condition used to filter cars.
     */
    public FilteredCarIterator(List<Car> cars, Predicate<Car> filter) {
        this.cars = cars;
        this.filter = filter;
    }

    /**
     * Checks if there are more elements in the collection that match the filter condition.
     * @return true if there are more filtered elements, false otherwise.
     */
    @Override
    public boolean hasNext() {
        while (currentIndex < cars.size()) {
            // Test the current car against the filter condition
            if (filter.test(cars.get(currentIndex))) {
                return true;
            }
            currentIndex++;
        }
        return false; // No more filtered elements
    }

    /**
     * Retrieves the next Car object in the collection that matches the filter condition.
     * @return the next Car object that satisfies the filter condition.
     */
    @Override
    public Car next() {
        return cars.get(currentIndex++); // Return the current car and move to the next
    }
}