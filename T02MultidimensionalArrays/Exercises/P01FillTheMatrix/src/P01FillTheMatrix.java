import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(inputData[0]);
        String patternType = inputData[1];

        int[][] matrix;

        if (patternType.equals("A")) {
            matrix = generateMatrixByPatternA(matrixSize);
        } else {
            matrix = generateMatrixByPatternB(matrixSize);
        }
        printMatrix(matrix);
    }

    private static int[][] generateMatrixByPatternA(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize * matrixSize; i++) {
            matrix[i % matrixSize][i / matrixSize] = i + 1;
        }
        return matrix;
    }


    private static int[][] generateMatrixByPatternB(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize * matrixSize; i++) {
            int column = i / matrixSize;
            int row = i % matrixSize;
            if (column % 2 == 0) {
                matrix[row][column] = i + 1;
            } else {
                matrix[matrixSize - 1 - row][column] = i + 1;
            }
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
