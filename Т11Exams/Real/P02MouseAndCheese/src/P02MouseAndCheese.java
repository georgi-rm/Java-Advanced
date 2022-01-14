import java.util.Scanner;

public class P02MouseAndCheese {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfTerritory = Integer.parseInt(scanner.nextLine());

        char[][] territory = readMatrix(sizeOfTerritory, scanner);

        Mouse mouse = new Mouse(0, 0);

        for (int row = 0; row < territory.length; row++) {
            for (int column = 0; column < territory[row].length; column++) {
                if (territory[row][column] == 'M') {
                    mouse = new Mouse(row, column);
                }
            }
        }

        boolean isMouseInTerritory = true;

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String direction = input;
            territory[mouse.getRow()][mouse.getColumn()] = '-';

            mouse.moveInDirection(direction);

            if (!isInBounds(mouse.getRow(), mouse.getColumn(), territory)) {
                isMouseInTerritory = false;
                break;
            }

            boolean repeatStep = false;
            char currentSymbol = territory[mouse.getRow()][mouse.getColumn()];
            territory[mouse.getRow()][mouse.getColumn()] = 'M';
            if (currentSymbol == 'B') {
                repeatStep = true;
            } else if (currentSymbol == 'c') {
                mouse.eatCheese();
            }

            if (!repeatStep) {
                input = scanner.nextLine();
            }
        }

        if (!isMouseInTerritory) {
            System.out.println("Where is the mouse?");
        }

        if (mouse.getNumberOfCheeseEaten() < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - mouse.getNumberOfCheeseEaten());
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", mouse.getNumberOfCheeseEaten());
        }

        printMatrix(territory);

    }

    private static class Mouse {
        private int row;
        private int column;
        private int numberOfCheeseEaten;

        public Mouse(int row, int column) {
            this.row = row;
            this.column = column;
            this.numberOfCheeseEaten = 0;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }

        public int getNumberOfCheeseEaten() {
            return numberOfCheeseEaten;
        }

        public void eatCheese() {
            this.numberOfCheeseEaten++;
        }

        public void moveInDirection(String direction) {
            switch (direction) {
                case "up":
                    this.row--;
                    break;
                case "down":
                    this.row++;
                    break;
                case "left":
                    this.column--;
                    break;
                case "right":
                    this.column++;
                    break;

            }
        }
    }

    private static boolean isInBounds(int row, int column, char[][] matrix) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length;
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();

            for (int column = 0; column < size; column++) {
                matrix[row] = line.toCharArray();
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
