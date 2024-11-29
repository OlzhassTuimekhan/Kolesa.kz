import java.util.Stack;

public class CarPurchaseCaretaker {
    private final Stack<CarPurchaseMemento> mementos = new Stack<>();

    public void saveState(CarPurchaseMemento memento) {
        mementos.push(memento);
    }

    public CarPurchaseMemento undoState() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null; // Если откат невозможен
    }

    public boolean hasUndo() {
        return !mementos.isEmpty();
    }
}