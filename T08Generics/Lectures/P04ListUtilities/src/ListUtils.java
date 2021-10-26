import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T minElement = list.get(0);
        for (T element : list) {
            if ( element.compareTo(minElement) < 0 ) {
                minElement = element;
            }
        }
        return minElement;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T maxElement = list.get(0);
        for (T element : list) {
            if ( element.compareTo(maxElement) > 0 ) {
                maxElement = element;
            }
        }
        return maxElement;
    }
}
