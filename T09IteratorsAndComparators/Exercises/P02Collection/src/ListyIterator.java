import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListyIterator(String... input) {
        this.data = new ArrayList<>();
        this.data.addAll(Arrays.asList(input));
        this.index = 0;
    }

    public boolean hasNext() {
        return this.index + 1 < this.data.size();
    }

    public boolean move() {
        if (!this.hasNext()) {
            return false;
        }
        this.index++;
        return true;
    }

    public void print() {
        if (this.data.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(data.get(this.index));
    }

    public void printAll() {
        if (this.data.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }

        this.forEach(e -> System.out.printf("%s ", e));
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int iteratorIndex = 0;
            @Override
            public boolean hasNext() {
                return this.iteratorIndex < data.size();
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    return null;
                }
                String element = data.get(this.iteratorIndex);
                this.iteratorIndex++;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
//        this.data.forEach(action);

        Iterator<String> iterator = this.iterator();

        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }
}
