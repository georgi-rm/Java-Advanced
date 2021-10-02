import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bossHealth = 3000000;
        int playerHealth = 18500;

        double playerDamage = Double.parseDouble(scanner.nextLine());
        int playerPositionRow = 15 / 2;
        int playerPositionColumn = 15 / 2;

        boolean isPreviousSpellCloud = false;
        String killedBySpell = "";

        while (true) {
            bossHealth -= playerDamage;

            if (isPreviousSpellCloud) {
                playerHealth -= 3500;
                isPreviousSpellCloud = false;
            }

            if (playerHealth <= 0) {
                killedBySpell = "Plague Cloud";
                break;
            }

            if (bossHealth <= 0) {
                break;
            }

            String[] bossCast = scanner.nextLine().split("\\s+");

            String spell = bossCast[0];
            int bossHitRow = Integer.parseInt(bossCast[1]);
            int bossHitColumn = Integer.parseInt(bossCast[2]);

            int[][] matrixWithDamagedFields = getMatrixOfDamagedFields(bossHitRow, bossHitColumn);

            if (matrixWithDamagedFields[playerPositionRow][playerPositionColumn] == 1) {
                if (isSafeSpot(playerPositionRow - 1, playerPositionColumn, matrixWithDamagedFields)) {
                    playerPositionRow--;
                } else if (isSafeSpot(playerPositionRow, playerPositionColumn + 1, matrixWithDamagedFields)) {
                    playerPositionColumn++;
                } else if (isSafeSpot(playerPositionRow + 1, playerPositionColumn, matrixWithDamagedFields)) {
                    playerPositionRow++;
                } else if (isSafeSpot(playerPositionRow, playerPositionColumn - 1, matrixWithDamagedFields)) {
                    playerPositionColumn--;
                } else {
                    int spellDamage;
                    if (spell.equals("Cloud")) {
                        spellDamage = 3500;
                        isPreviousSpellCloud = true;
                        killedBySpell = "Plague Cloud";
                    } else {
                        spellDamage = 6000;
                        killedBySpell = "Eruption";
                    }

                    playerHealth -= spellDamage;
                    if (playerHealth <= 0) {
                        break;
                    }
                }
            }
        }

        if (bossHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        }

        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n", killedBySpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }

        System.out.printf("Final position: %d, %d", playerPositionRow, playerPositionColumn);

    }

    private static boolean isSafeSpot(int row, int column, int[][] matrixWithDamagedFields) {
        if (!areCoordinatesValid(row, column, matrixWithDamagedFields)) {
            return false;
        }

        return matrixWithDamagedFields[row][column] != 1;
    }

    private static int[][] getMatrixOfDamagedFields(int bossHitRow, int bossHitColumn) {
        int[][] matrix = new int[15][15];

        for (int row = bossHitRow - 1; row <= bossHitRow + 1; row++) {
            for (int column = bossHitColumn - 1; column <= bossHitColumn + 1; column++) {
                if (areCoordinatesValid(row, column, matrix)) {
                    matrix[row][column] = 1;
                }
            }
        }

        return matrix;
    }

    private static boolean areCoordinatesValid(int row, int column, int[][] matrix) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length;
    }
}
