import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> jarContent;

    public Jar(){
        this.jarContent = new ArrayDeque<>();
    }

    public void add(T element) {
        jarContent.push(element);
    }

    public T remove() {
        return jarContent.pop();
    }
}
