import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(rows, columns, scanner, ", ");

        int[][] maxSubMatrix = new int[2][2];
        int maxSumOfSubMatrix = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int column = 0; column < matrix[row].length - 1; column++) {
                int sum = matrix[row][column]
                        + matrix[row][column + 1]
                        + matrix[row + 1][column]
                        + matrix[row + 1][column + 1];
                if (sum > maxSumOfSubMatrix) {
                    maxSumOfSubMatrix = sum;
                    maxSubMatrix[0][0] = matrix[row][column];
                    maxSubMatrix[0][1] = matrix[row][column + 1];
                    maxSubMatrix[1][0] = matrix[row + 1][column];
                    maxSubMatrix[1][1] = matrix[row + 1][column + 1];
                }
            }
        }

        printMatrix(maxSubMatrix);
        System.out.println(maxSumOfSubMatrix);


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
