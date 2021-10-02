import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(rows, columns, scanner, "\\s+");

        int[][] maxSubMatrix = new int[3][3];
        int maxSumOfSubMatrix = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int column = 0; column < matrix[row].length - 2; column++) {
                int sum = matrix[row][column]
                        + matrix[row][column + 1]
                        + matrix[row][column + 2]
                        + matrix[row + 1][column]
                        + matrix[row + 1][column + 1]
                        + matrix[row + 1][column + 2]
                        + matrix[row + 2][column]
                        + matrix[row + 2][column + 1]
                        + matrix[row + 2][column + 2];
                if (sum > maxSumOfSubMatrix) {
                    maxSumOfSubMatrix = sum;
                    maxSubMatrix[0][0] = matrix[row][column];
                    maxSubMatrix[0][1] = matrix[row][column + 1];
                    maxSubMatrix[0][2] = matrix[row][column + 2];
                    maxSubMatrix[1][0] = matrix[row + 1][column];
                    maxSubMatrix[1][1] = matrix[row + 1][column + 1];
                    maxSubMatrix[1][2] = matrix[row + 1][column + 2];
                    maxSubMatrix[2][0] = matrix[row + 2][column];
                    maxSubMatrix[2][1] = matrix[row + 2][column + 1];
                    maxSubMatrix[2][2] = matrix[row + 2][column + 2];
                }
            }
        }
        System.out.printf( "Sum = %d%n", maxSumOfSubMatrix);
        printMatrix(maxSubMatrix);



    }

    private static int[][] readMatrix(int rows, int columns, Scanner scanner, String separator) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(separator))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
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
