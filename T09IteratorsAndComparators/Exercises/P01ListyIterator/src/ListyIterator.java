import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index = 0;

    public ListyIterator(String... input) {
        this.data = new ArrayList<>();
        this.data.addAll(Arrays.asList(input));
    }

    public boolean hasNext() {
        return index + 1 < data.size();
    }

    public boolean move() {
        if (!this.hasNext()) {
            return false;
        }
        index++;
        return true;
    }

    public void print() {
        if (this.data.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(data.get(index));
    }
}
