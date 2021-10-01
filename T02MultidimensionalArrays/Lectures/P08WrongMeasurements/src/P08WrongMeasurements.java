import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] originalMatrix = readMatrix(rows, scanner, "\\s+");
        int[][] fixedMatrix = new int[rows][];

        for (int row = 0; row < originalMatrix.length; row++) {
            int[] columnValues = new int[originalMatrix[row].length];
            for (int column = 0; column < columnValues.length; column++) {
                columnValues[column] = originalMatrix[row][column];
            }
            fixedMatrix[row] = columnValues;
        }

        String[] wrongNumberPosition = scanner.nextLine().split("\\s+");
        int wrongNumberRow = Integer.parseInt(wrongNumberPosition[0]);
        int wrongNumberColumn = Integer.parseInt(wrongNumberPosition[1]);

        int wrongValue = originalMatrix[wrongNumberRow][wrongNumberColumn];

        for (int row = 0; row < originalMatrix.length; row++) {
            for (int column = 0; column < originalMatrix[row].length; column++) {
                if (wrongValue == originalMatrix[row][column]) {
                    fixValueInMatrix(row, column, originalMatrix, fixedMatrix);
                }
            }
        }

        printMatrix(fixedMatrix);

    }

    private static void fixValueInMatrix(int wrongValueRow, int wrongValueColumn, int[][] originalMatrix, int[][] fixedMatrix) {
        int correctNumber = 0;
        int wrongValue = originalMatrix[wrongValueRow][wrongValueColumn];

        int upperRow = wrongValueRow - 1;
        if (upperRow >= 0) {
            int upperValue = originalMatrix[upperRow][wrongValueColumn];
            if (upperValue != wrongValue) {
                correctNumber += upperValue;
            }
        }

        int lowerRow = wrongValueRow + 1;
        if (lowerRow < originalMatrix.length) {
            int lowerValue = originalMatrix[lowerRow][wrongValueColumn];
            if (lowerValue != wrongValue) {
                correctNumber += lowerValue;
            }
        }

        int leftColumn = wrongValueColumn - 1;
        if (leftColumn >= 0) {
            int leftValue = originalMatrix[wrongValueRow][leftColumn];
            if (leftValue != wrongValue) {
                correctNumber += leftValue;
            }
        }

        int rightColumn = wrongValueColumn + 1;
        if (rightColumn < originalMatrix[wrongValueRow].length) {
            int rightValue = originalMatrix[wrongValueRow][rightColumn];
            if (rightValue != wrongValue) {
                correctNumber += rightValue;
            }
        }

        fixedMatrix[wrongValueRow][wrongValueColumn] = correctNumber;

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%d ", matrix[row][column]);
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int rows, Scanner scanner, String separator) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(separator))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
