public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.size(); i++) {
            T firstElement = customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                T secondElement = customList.get(j);
                if (firstElement.compareTo(secondElement) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
