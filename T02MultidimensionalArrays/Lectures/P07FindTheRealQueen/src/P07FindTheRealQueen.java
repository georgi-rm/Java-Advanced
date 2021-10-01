import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int squareMatrixSize = 8;

        String[][] chestBoard = readMatrix(squareMatrixSize, scanner, "\\s+");

        for (int row = 0; row < squareMatrixSize; row++) {
            for (int column = 0; column < squareMatrixSize; column++) {
                if (isQueenOnPosition(row, column, chestBoard)) {
                    if (isRealQueen(row, column, chestBoard)) {
                        System.out.printf("%d %d", row, column);
                        break;
                    }
                }
            }
        }
    }

    private static boolean isQueenOnPosition(int row, int column, String[][] chestBoard) {
        return chestBoard[row][column].equals("q");
    }

    private static boolean isRealQueen(int queenRow, int queenColumn, String[][] chestBoard) {
        if (!isQueenOnPosition(queenRow, queenColumn, chestBoard)) {
            return false;
        }

        // Horizontal move
        for (int column = 0; column < chestBoard[queenRow].length; column++) {
            if (column == queenColumn) {
                continue;
            }
            if (isQueenOnPosition(queenRow, column, chestBoard)) {
                return false;
            }
        }

        // Vertical move
        for (int row = 0; row < chestBoard.length; row++) {
            if (row == queenRow) {
                continue;
            }
            if (isQueenOnPosition(row, queenColumn, chestBoard)) {
                return false;
            }
        }

        // UpperLeftDiagonal
        int currentRow = queenRow - 1;
        int currentColumn = queenColumn - 1;

        while (currentRow >= 0 && currentColumn >= 0) {
            if (isQueenOnPosition(currentRow, currentColumn, chestBoard)) {
                return false;
            }
            currentRow--;
            currentColumn--;
        }

        // UpperRightDiagonal
        currentRow = queenRow - 1;
        currentColumn = queenColumn + 1;

        while (currentRow >= 0 && currentColumn < chestBoard[currentRow].length) {
            if (isQueenOnPosition(currentRow, currentColumn, chestBoard)) {
                return false;
            }
            currentRow--;
            currentColumn++;
        }

        // LowerLeftDiagonal
        currentRow = queenRow + 1;
        currentColumn = queenColumn - 1;

        while (currentRow < chestBoard.length && currentColumn >= 0) {
            if (isQueenOnPosition(currentRow, currentColumn, chestBoard)) {
                return false;
            }
            currentRow++;
            currentColumn--;
        }


        // LowerRightDiagonal
        currentRow = queenRow + 1;
        currentColumn = queenColumn + 1;

        while (currentRow < chestBoard.length && currentColumn < chestBoard[currentRow].length) {
            if (isQueenOnPosition(currentRow, currentColumn, chestBoard)) {
                return false;
            }
            currentRow++;
            currentColumn++;
        }


        return true;
    }


    private static String[][] readMatrix(int rows, Scanner scanner, String separator) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(separator);
        }
        return matrix;
    }
}
