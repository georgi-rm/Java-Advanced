import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        String[][] matrix = fillMatrixWithPalindrome(rows, columns);
        printMatrix(matrix);

    }

    private static String[][] fillMatrixWithPalindrome(int rows, int columns) {
        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = String.format("%c%c%c", row + 'a', row + column + 'a', row + 'a');
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%s ", matrix[row][column]);
            }
            System.out.println();
        }
    }
}
