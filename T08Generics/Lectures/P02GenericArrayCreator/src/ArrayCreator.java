import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static<T> T[] create(int length, T item) {
        T[] myArray = (T[])Array.newInstance(item.getClass(), length);
        Arrays.fill(myArray, item);
        return myArray;
    }

    public static<T> T[] create(Class<T> clazz, int length, T item) {
        T[] myArray = (T[])Array.newInstance(clazz, length);
        Arrays.fill(myArray, item);
        return myArray;
    }
}
