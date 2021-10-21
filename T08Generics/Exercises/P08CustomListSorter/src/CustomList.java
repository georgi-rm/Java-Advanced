import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstValue = this.elements.get(firstIndex);
        T secondValue = elements.get(secondIndex);
        this.elements.remove(firstIndex);
        this.elements.add(firstIndex, secondValue);
        this.elements.remove(secondIndex);
        this.elements.add(secondIndex, firstValue);
    }

    public int countGreaterThan(T element) {
        return (int) elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        T maxElement = this.elements.get(0);
        for (T element : elements) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    public T getMin() {
        T minElement = this.elements.get(0);
        for (T element : elements) {
            if (element.compareTo(minElement) < 0) {
                minElement = element;
            }
        }
        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (T element : elements) {
            stringBuilder.append(element).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    public int size() {
        return this.elements.size();
    }

    public T get(int index) {
        return this.elements.get(index);
    }
}
