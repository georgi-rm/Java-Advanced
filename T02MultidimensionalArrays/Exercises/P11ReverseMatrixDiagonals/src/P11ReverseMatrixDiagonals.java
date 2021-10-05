import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(rows, columns, scanner, "\\s+");

        for (int column = matrix[matrix.length - 1].length - 1; column > 0; column--) {
            printReverseDiagonal(matrix.length - 1, column, matrix);
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            printReverseDiagonal(row, 0, matrix);
        }

    }

    private static void printReverseDiagonal(int startRow, int startColumn, int[][] matrix) {
        for (int row = startRow, column = startColumn; row >= 0 && column < matrix[row].length; row--, column++) {
            System.out.printf("%d ", matrix[row][column]);
        }
        System.out.println();
    }

    private static int[][] readMatrix(int rows, int columns, Scanner scanner, String separator) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(separator))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
