import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Lake implements Iterable<Integer>{
    List<Integer> lake;

    public Lake(Integer... values) {
        this.lake = Arrays.stream(values).collect(Collectors.toList());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

//    @Override
//    public void forEach(Consumer<? super Integer> action) {
//        Iterable.super.forEach(action);
//    }

    class Frog implements Iterator<Integer> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {
            int currentIndex = this.index;
            this.index += 2;
            if (this.index >= lake.size() && this.index % 2 == 0){
                this.index = 1;

            }
            return lake.get(currentIndex);
        }
    }
}
