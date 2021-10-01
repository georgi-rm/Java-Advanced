import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        String[][] firstMatrix = readMatrix(rows, columns, scanner);
        String[][] secondMatrix = readMatrix(rows, columns, scanner);
        String[][] finalMatrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (firstMatrix[row][column].equals(secondMatrix[row][column])) {
                    finalMatrix[row][column] = firstMatrix[row][column];
                } else {
                    finalMatrix[row][column] = "*";
                }
            }
        }

        printMatrix(finalMatrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%s ", matrix[row][column]);
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(int rows, int columns, Scanner scanner) {
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
