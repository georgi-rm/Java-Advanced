import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = readMatrix(rows, columns, scanner);

        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean isNumberFoundInMatrix = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (numberToFind == matrix[row][column]) {
                    System.out.printf("%d %d%n", row, column);
                    isNumberFoundInMatrix = true;
                }
            }
        }
        if (!isNumberFoundInMatrix) {
            System.out.println("not found");
        }
    }

    private static int[][] readMatrix(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
