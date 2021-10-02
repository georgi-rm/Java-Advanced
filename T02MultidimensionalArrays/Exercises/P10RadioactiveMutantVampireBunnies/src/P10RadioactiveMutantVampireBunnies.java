import java.util.Scanner;

public class P10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int lairRows = Integer.parseInt(dimensions[0]);
        int lairColumns = Integer.parseInt(dimensions[1]);

        char[][] lair = readMatrix(lairRows, lairColumns, scanner);

        String directions = scanner.nextLine();

        int playerRow = 0;
        int playerColumn = 0;
        boolean isPlayerFound = false;
        for (int row = 0; row < lair.length; row++) {
            for (int column = 0; column < lair[row].length; column++) {
                if (lair[row][column] == 'P') {
                    playerRow = row;
                    playerColumn = column;
                    isPlayerFound = true;
                    break;
                }
            }
            if (isPlayerFound) {
                break;
            }
        }
        boolean isPlayerEscaped = false;
        for (int move = 0; move < directions.length(); move++) {
            lair[playerRow][playerColumn] = '.';
            switch (directions.charAt(move)) {
                case 'R':
                    if (playerColumn + 1 >= lair[playerRow].length) {
                        isPlayerEscaped = true;
                    } else {
                        playerColumn++;
                    }
                    break;
                case 'L':
                    if (playerColumn - 1 < 0) {
                        isPlayerEscaped = true;
                    } else {
                        playerColumn--;
                    }
                    break;
                case 'U':
                    if (playerRow - 1  < 0) {
                        isPlayerEscaped = true;
                    } else {
                        playerRow--;
                    }
                    break;
                case 'D':
                    if (playerRow + 1 >= lair.length) {
                        isPlayerEscaped = true;
                    } else {
                        playerRow++;
                    }
                    break;
            }
            if (!isPlayerEscaped) {
                if (lair[playerRow][playerColumn] != 'B') {
                    lair[playerRow][playerColumn] = 'P';
                }
            }

            lair = spreadBunnies(lair);

            if (isPlayerEscaped) {
                break;
            } else {
                if (isPlayerDead(lair)) {
                    break;
                }
            }
        }

        printMatrix(lair);

        if (isPlayerEscaped) {
            System.out.print("won: ");
        } else {
            System.out.print("dead: ");
        }
        System.out.printf("%d %d", playerRow, playerColumn);


    }

    private static boolean isPlayerDead(char[][] lair) {
        for (int row = 0; row < lair.length; row++) {
            for (int column = 0; column < lair[row].length; column++) {
                if (lair[row][column] == 'P') {
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] spreadBunnies(char[][] lair) {
        char[][] lairAfterSpread = new char[lair.length][lair[0].length];
        for (int row = 0; row < lair.length; row++) {
            for (int column = 0; column < lair[row].length; column++) {
                if (isBunny(row, column, lair) || isBunny(row, column - 1, lair)
                        || isBunny(row, column + 1, lair)
                        || isBunny(row - 1, column, lair)
                        || isBunny(row + 1, column, lair)){
                    lairAfterSpread[row][column] = 'B';
                } else {
                    lairAfterSpread[row][column] = lair[row][column];
                }
            }

        }
        return lairAfterSpread;
    }

    private static char[][] readMatrix(int rows, int columns, Scanner scanner) {
        char[][] matrix = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }

    private static boolean isBunny(int row, int column, char[][] matrix) {
        if (!areCoordinatesValid(row, column, matrix)) {
            return false;
        }

        return matrix[row][column] == 'B';
    }

    private static boolean areCoordinatesValid(int row, int column, char[][] matrix) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length;
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
