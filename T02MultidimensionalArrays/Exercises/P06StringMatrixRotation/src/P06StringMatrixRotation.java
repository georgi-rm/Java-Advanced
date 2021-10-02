import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\bRotate\\((?<degree>[0-9]+)\\)");
        Matcher matcher = pattern.matcher(input);

        int degree = 0;

        if (matcher.find()) {
            degree = Integer.parseInt(matcher.group("degree"));
        }

        List<String> matrixLines = new ArrayList<>();

        input = scanner.nextLine();

        while (!input.equals("END")) {
            matrixLines.add(input);
            input = scanner.nextLine();
        }

        char[][] matrix = fillMatrixFromList(matrixLines);

        int timesToRotateMatrix = (degree % 360) / 90;

        while (timesToRotateMatrix-- > 0) {
            matrix = rotateMatrixTo90Degree(matrix);
        }

        printMatrix(matrix);

    }

    private static char[][] rotateMatrixTo90Degree(char[][] originalMatrix) {
        int originalRows = originalMatrix.length;
        int originalColumns = originalMatrix[0].length;
        char[][] rotatedMatrix = new char[originalColumns][originalRows];

        for (int row = 0; row < originalRows; row++) {
            for (int column = 0; column < originalColumns; column++) {
                rotatedMatrix[column][originalRows - row - 1] = originalMatrix[row][column];
            }
        }
        return rotatedMatrix;
    }

    private static char[][] fillMatrixFromList(List<String> matrixData) {
        int columns = matrixData.stream().mapToInt(String::length).max().orElse(0);

        char[][] matrix = new char[matrixData.size()][columns];

        for (int row = 0; row < matrixData.size(); row++) {
            for (int column = 0; column < columns; column++) {
                char symbol;
                if (column < matrixData.get(row).length()) {
                    symbol = matrixData.get(row).charAt(column);
                } else {
                    symbol = ' ';
                }
                matrix[row][column] = symbol;
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%c", matrix[row][column]);
            }
            System.out.println();
        }
    }
}
