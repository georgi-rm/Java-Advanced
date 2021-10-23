import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Room>{
    private final String name;
    private final List<Room> rooms;

    public Clinic(String name, int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.rooms = new ArrayList<>();
        for (int i = 0; i < numberOfRooms; i++) {
            this.rooms.add(new Room());
        }
    }

    public boolean addPet(Pet pet) {
        IteratorAdding addingIterator = new IteratorAdding();
        while (addingIterator.hasNext()) {
            Room currentRoom = addingIterator.next();
            if (currentRoom.isEmpty()) {
                return currentRoom.occupyRoom(pet);
            }
        }
        return false;
    }


    public boolean hasFreeRooms() {
        IteratorAdding addingIterator = new IteratorAdding();
        while (addingIterator.hasNext()) {
            Room currentRoom = addingIterator.next();
            if (currentRoom.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        IteratorRelease releaseIterator = new IteratorRelease();
        while (releaseIterator.hasNext()) {
            Room currentRoom = releaseIterator.next();
            if (!currentRoom.isEmpty()) {
                return currentRoom.clearRoom();
            }
        }
        return false;
    }

    public Room getRoomByNumber(int number) {
        return rooms.get(number-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Room room : rooms) {
            stringBuilder.append(room.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Room> iterator() {
        return rooms.iterator();
    }

    class IteratorAdding implements Iterator<Room> {
        private int index = rooms.size() / 2;
        private int indexOffset = 0;
        @Override
        public boolean hasNext() {
            return index < rooms.size() && index >= 0;
        }

        @Override
        public Room next() {
            int currentIndex = this.index;
            if (this.index >= rooms.size() / 2) {
                indexOffset++;
                index = rooms.size() / 2 - indexOffset;
            } else {
                index = rooms.size() / 2 + indexOffset;
            }
            return rooms.get(currentIndex);
        }
    }

    class IteratorRelease implements Iterator<Room> {
        private int index = rooms.size() / 2;
        @Override
        public boolean hasNext() {
            return index < rooms.size() && index >= 0;
        }

        @Override
        public Room next() {
            int currentIndex = this.index;
            this.index++;
            if (this.index > rooms.size()){
                this.index = 1;
            } else if (this.index == rooms.size() / 2) {
                this.index = -1;
            }
            return rooms.get(currentIndex);
        }
    }
}
