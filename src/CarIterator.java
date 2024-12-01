/**
 * Interface for the Iterator pattern.
 * Provides a standard way to iterate over a collection of Car objects.
 */
interface CarIterator {
    /**
     * Checks if there are more elements to iterate over in the collection.
     * @return true if there are more elements, false otherwise.
     */
    boolean hasNext();

    /**
     * Retrieves the next Car object in the collection.
     * @return the next Car object.
     */
    Car next();
}