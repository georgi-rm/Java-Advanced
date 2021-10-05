import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rowsOfMatrix = Integer.parseInt(dimensions[0]);
        int columnsOfMatrix = Integer.parseInt(dimensions[1]);

        String[][] matrix = readMatrix(rowsOfMatrix, columnsOfMatrix, scanner, "\\s+");

        String fillSymbol = scanner.nextLine();

        int[] startCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startRow = startCoordinates[0];
        int startColumn = startCoordinates[1];

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        if (startRow >= 0 && startRow < matrix.length && startColumn >= 0 && startColumn < matrix[startRow].length) {
            String symbolToReplace = matrix[startRow][startColumn];
            stack.push(startCoordinates);
            replaceSymbol(startRow, startColumn, matrix, symbolToReplace, fillSymbol);

            while (!stack.isEmpty()) {
                int[] coordinates = stack.peek();

                int row = coordinates[0];
                int column = coordinates[1];

                if (replaceSymbol(row - 1, column, matrix, symbolToReplace, fillSymbol)) {
                    int[] newCoordinates = new int[2];
                    newCoordinates[0] = row - 1;
                    newCoordinates[1] = column;
                    stack.push(newCoordinates);
                } else if (replaceSymbol(row + 1, column, matrix, symbolToReplace, fillSymbol)) {
                    int[] newCoordinates = new int[2];
                    newCoordinates[0] = row + 1;
                    newCoordinates[1] = column;
                    stack.push(newCoordinates);
                } else if (replaceSymbol(row, column - 1, matrix, symbolToReplace, fillSymbol)) {
                    int[] newCoordinates = new int[2];
                    newCoordinates[0] = row;
                    newCoordinates[1] = column - 1;
                    stack.push(newCoordinates);
                } else if (replaceSymbol(row, column + 1, matrix, symbolToReplace, fillSymbol)) {
                    int[] newCoordinates = new int[2];
                    newCoordinates[0] = row;
                    newCoordinates[1] = column + 1;
                    stack.push(newCoordinates);
                } else {
                    stack.pop();
                }
            }
        }
        printMatrix(matrix);
    }

    private static boolean replaceSymbol(int row, int column, String[][] matrix, String symbolToReplace, String symbol) {
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[row].length) {
            return false;
        }
        if (matrix[row][column].equals(symbolToReplace)) {
            matrix[row][column] = symbol;
            return true;
        }
        return false;
    }

    private static String[][] readMatrix(int rows, int columns, Scanner scanner, String separator) {
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(separator);
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }
}
