import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = readMatrix(rows, scanner, "\\s+");

        for (int row = 0; row < rows; row++) {
            System.out.printf("%s ", matrix[row][row]);
        }
        System.out.println();

        for (int row = 0; row < rows; row++) {
            System.out.printf("%s ", matrix[rows - 1 - row][row]);
        }
    }

    private static String[][] readMatrix(int rows, Scanner scanner, String separator) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(separator);
        }
        return matrix;
    }
}
