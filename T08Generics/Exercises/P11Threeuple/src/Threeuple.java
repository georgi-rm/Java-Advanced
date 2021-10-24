public class Threeuple<F, S, T>{
    private final F item1;
    private final S item2;
    private final T item3;

    public Threeuple(F item1, S item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item1).append(" -> ")
                .append(item2).append(" -> ")
                .append(item3);

        return stringBuilder.toString();
    }
}
