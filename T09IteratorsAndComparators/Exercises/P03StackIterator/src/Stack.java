import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T>{
    private List<T> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException();
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            action.accept(stack.get(i));
        }
    }
}
