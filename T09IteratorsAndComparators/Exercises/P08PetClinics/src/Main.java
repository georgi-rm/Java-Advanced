import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        while (numberOfCommands-- > 0) {
            String[] commandParameters = scanner.nextLine().split("\\s+");
            String commandName = commandParameters[0];

            switch (commandName) {
                case "Create":
                    String objectToCreate = commandParameters[1];
                    if (objectToCreate.equals("Pet")) {
                        String petName = commandParameters[2];
                        int petAge = Integer.parseInt(commandParameters[3]);
                        String petKind = commandParameters[4];
                        pets.put(petName, new Pet(petName, petAge, petKind));
                    } else {
                        String clinicName = commandParameters[2];
                        int numberOfRooms = Integer.parseInt(commandParameters[3]);
                        try {
                            clinics.put(clinicName, new Clinic(clinicName, numberOfRooms));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid Operation!");
                        }
                    }
                    break;
                case "Add":
                    String petName = commandParameters[1];
                    String clinicName = commandParameters[2];
                    System.out.println(clinics.get(clinicName).addPet(pets.get(petName)));
                    break;
                case "Release":
                    String clinicNameRelease = commandParameters[1];
                    System.out.println(clinics.get(clinicNameRelease).release());
                    break;
                case "HasEmptyRooms":
                    String clinicNameCheckFree = commandParameters[1];
                    System.out.println(clinics.get(clinicNameCheckFree).hasFreeRooms());
                    break;
                case "Print":
                    String clinicNamePrint = commandParameters[1];
                    if (commandParameters.length == 2) {
                        System.out.print(clinics.get(clinicNamePrint));
                    } else {
                        int roomNumber = Integer.parseInt(commandParameters[2]);
                        System.out.println(clinics.get(clinicNamePrint).getRoomByNumber(roomNumber));
                    }
                    break;
            }
        }
    }
}
