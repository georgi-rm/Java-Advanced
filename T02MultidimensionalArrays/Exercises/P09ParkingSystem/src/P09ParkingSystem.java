import java.util.Arrays;
import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int parkingRows = dimensions[0];
        int parkingColumns = dimensions[1];

        boolean[][] occupiedParkingSpots = new boolean[parkingRows][parkingColumns];

        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String[] coordinates = input.split("\\s+");
            int startRow = Integer.parseInt(coordinates[0]);
            int parkingSpotRow = Integer.parseInt(coordinates[1]);
            int parkingSpotColumn = Integer.parseInt(coordinates[2]);

            int distanceToParkingSpot = Math.abs(parkingSpotRow - startRow) + 1;

            boolean isFoundParkingSpot = false;
            int offset = 0;
            while (parkingSpotColumn + offset < occupiedParkingSpots[parkingSpotRow].length
                    || parkingSpotColumn - offset > 0) {

                if (parkTheCar(parkingSpotRow, parkingSpotColumn - offset, occupiedParkingSpots)) {
                    distanceToParkingSpot += parkingSpotColumn - offset;
                    isFoundParkingSpot = true;
                    break;
                }

                if (parkTheCar(parkingSpotRow, parkingSpotColumn + offset, occupiedParkingSpots)) {
                    distanceToParkingSpot += parkingSpotColumn + offset;
                    isFoundParkingSpot = true;
                    break;
                }
                offset++;
            }

            if (isFoundParkingSpot) {
                System.out.println(distanceToParkingSpot);
            } else {
                System.out.printf("Row %d full%n", parkingSpotRow);
            }


            input = scanner.nextLine();
        }
    }

    private static boolean parkTheCar(int row, int column, boolean[][] occupiedParkingSpots) {
        if (row < 0 || row >= occupiedParkingSpots.length || column <= 0 || column >= occupiedParkingSpots[row].length) {
            return false;
        }

        if (occupiedParkingSpots[row][column]) {
            return false;
        }

        occupiedParkingSpots[row][column] = true;
        return true;
    }
}
