import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LinkedList implements Iterable<Integer> {
    private Node head;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            newNode.next = head;
        }
        this.head = newNode;
        size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        Node currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        this.size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list");
        }
        int result = this.head.value;
        this.head = this.head.next;
        this.size--;
        return result;
    }

    public void removeFirstElement(Integer element) {
        Node currentNode = this.head;
        Node previousNode = null;
        if (this.head.value == element)
        {
            this.head = this.head.next;
            this.size--;
            return;
        }
        while (currentNode.next != null) {
            if (currentNode.value == element) {
                previousNode.next = currentNode.next;
                this.size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public int removeLast() {
        if (this.size < 2) {
            return removeFirst();
        }
        int result = 0;
        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        //here
        result = currentNode.next.value;
        currentNode.next = null;
        this.size--;
        return result;
    }

    public int get(int index) {
        checkIndex(index);
        int result = 0;
        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentNode != null) {
            if (currentIndex == index) {
                result = currentNode.value;
                break;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }

        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("The index " + index + " is out of bounds");
        }
    }


    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

//    public void forEach(Consumer<Integer> consumer) {
//        Node currentNode = this.head;
//        while (currentNode != null) {
//            consumer.accept(currentNode.value);
//            currentNode = currentNode.next;
//        }
//    }

//    public int[] toArray(){
//        int[] array = new int[this.size];
//        int counter = 0;
//        Node currentNode = this.head;
//
//        while(currentNode != null){
//            array[counter] = currentNode.value;
//            currentNode = currentNode.next;
//            counter++;
//        }
//        return array;
//    }

    public int[] toArray() {
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }


    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Node currentNode = this.head;
        while (currentNode != null) {
            action.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    static class linkedListIterator implements Iterator<Node> {
        private Node currentNode;

        public linkedListIterator(Node currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        @Override
        public Node next() {
            Node previousNode = currentNode;
            currentNode = currentNode.next;
            return previousNode;
        }
    }
}