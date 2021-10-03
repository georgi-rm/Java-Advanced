import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][columns];

        generateMatrix(matrix);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] coordinates = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = coordinates[0];
            int column = coordinates[1];
            int radius = coordinates[2];

            matrix = doCrossFire(row, column, radius, matrix);

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static int[][] doCrossFire(int targetRow, int targetColumn, int radius, int[][] initialMatrix) {
        List<List<Integer>> listMatrix = new ArrayList<>();

        for (int row = 0; row < initialMatrix.length; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int column = 0; column < initialMatrix[row].length; column++) {
                if (!isCoordinateInCrossFire( row, column, targetRow, targetColumn, radius)) {
                    rowList.add(initialMatrix[row][column]);
                }
            }
            if (!rowList.isEmpty()) {
                listMatrix.add(rowList);
            }
        }
        int[][] newMatrix = new int[listMatrix.size()][];

        for (int row = 0; row < newMatrix.length; row++) {
            newMatrix[row] = listMatrix.get(row).stream().mapToInt(e -> e).toArray();
        }

        return newMatrix;
    }

    private static boolean isCoordinateInCrossFire(int row, int column, int targetRow, int targetColumn, int radius) {
        if (column == targetColumn && row >= targetRow - radius && row <= targetRow + radius) {
            return true;
        }

        return row == targetRow && column >= targetColumn - radius && column <= targetColumn + radius;
    }

    private static void generateMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (row * matrix[row].length) + column + 1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%d ", matrix[row][column]);
            }
            System.out.println();
        }
    }

}
