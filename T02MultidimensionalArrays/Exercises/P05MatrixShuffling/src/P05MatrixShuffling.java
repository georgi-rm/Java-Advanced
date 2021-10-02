import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        String[][] matrix = readMatrix(rows, columns, scanner, "\\s+");

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commandData = input.split("\\s+");

            if (isValidCommand(commandData, matrix)) {
                int row1 = Integer.parseInt(commandData[1]);
                int column1 = Integer.parseInt(commandData[2]);
                int row2 = Integer.parseInt(commandData[3]);
                int column2 = Integer.parseInt(commandData[4]);
                String temporaryValue = matrix[row1][column1];
                matrix[row1][column1] = matrix[row2][column2];
                matrix[row2][column2] = temporaryValue;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }

    private static boolean isValidCommand(String[] commandData, String[][] matrix) {
        if (commandData.length != 5) {
            return false;
        }

        if (!commandData[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandData[1]);
        int column1 = Integer.parseInt(commandData[2]);
        int row2 = Integer.parseInt(commandData[3]);
        int column2 = Integer.parseInt(commandData[4]);

        if (row1 < 0 || row1 > matrix.length) {
            return false;
        }

        if (row2 < 0 || row2 > matrix.length) {
            return false;
        }

        if (column1 < 0 || column1 > matrix[0].length) {
            return false;
        }

        if (column2 < 0 || column2 > matrix[0].length) {
            return false;
        }

        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%s ", matrix[row][column]);
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(int rows, int columns, Scanner scanner, String separator) {
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(separator);
        }
        return matrix;
    }

}
