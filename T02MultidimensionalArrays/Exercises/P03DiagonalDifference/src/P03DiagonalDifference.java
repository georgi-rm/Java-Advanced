import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int sumOfPrimaryDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;

        int[][] matrix = readMatrix(matrixSize, scanner, "\\s+");

        for (int row = 0; row < matrix.length; row++) {
            sumOfPrimaryDiagonal += matrix[row][row];
            sumOfSecondaryDiagonal += matrix[row][matrix.length - row - 1];
        }

        int difference = Math.abs( sumOfPrimaryDiagonal - sumOfSecondaryDiagonal);

        System.out.println(difference);

    }

    private static int[][] readMatrix(int matrixSize, Scanner scanner, String separator) {
        int[][] matrix = new int[matrixSize][];
        for (int row = 0; row < matrixSize; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(separator))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
