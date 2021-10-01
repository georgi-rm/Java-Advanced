import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstMatrixDimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(firstMatrixDimensions[0]);
        int columns = Integer.parseInt(firstMatrixDimensions[1]);

        int[][] firstMatrix = readMatrix(rows, columns, scanner);

        String[] secondMatrixDimensions = scanner.nextLine().split("\\s+");
        rows = Integer.parseInt(secondMatrixDimensions[0]);
        columns = Integer.parseInt(secondMatrixDimensions[1]);
        int[][] secondMatrix = readMatrix(rows, columns, scanner);

        if (areMatricesEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean areMatricesEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int column = 0; column < firstMatrix[row].length; column++) {
                if (firstMatrix[row][column] != secondMatrix[row][column]) {
                    return false;
                }
            }
        }
        return true;
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
