public class Room {
    private Pet pet;

    public Room() {
        this.pet = null;
    }

    public boolean occupyRoom(Pet pet) {
        if (!isEmpty()) {
            return false;
        }
        this.pet = pet;
        return true;
    }

    public boolean clearRoom() {
        if (isEmpty()) {
            return false;
        }
        this.pet = null;
        return true;
    }

    public boolean isEmpty() {
        return this.pet == null;
    }

    @Override
    public String toString() {
        String output;
        if (isEmpty()) {
            output = "Room empty";
        } else {
            output = String.format("%s %d %s", this.pet.getName(), pet.getAge(), pet.getKind());
        }
        return output;
    }
}
