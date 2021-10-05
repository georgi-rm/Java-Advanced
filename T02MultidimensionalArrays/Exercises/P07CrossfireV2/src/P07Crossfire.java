import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(rows, columns, matrix);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] coordinates = input.split("\\s+");

            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);
            int radius = Integer.parseInt(coordinates[2]);

            doCrossFire(row, column, radius, matrix);

            input = scanner.nextLine();
        }
        printMatrix(matrix);

    }

    private static void doCrossFire(int targetRow, int targetColumn, int radius, List<List<Integer>> matrix) {

        if (targetRow >= 0 && targetRow < matrix.size()) {
            for (int column = targetColumn + radius; column > targetColumn; column--) {
                if (column >= 0 && column < matrix.get(targetRow).size()) {
                    matrix.get(targetRow).remove(column);
                }
            }
        }

        for (int row = targetRow - radius; row <= targetRow + radius; row++) {
            if (row >= 0 && row < matrix.size() && targetColumn >= 0 && targetColumn < matrix.get(row).size()) {
                matrix.get(row).remove(targetColumn);
            }
        }

        if (targetRow >= 0 && targetRow < matrix.size()) {
            for (int column = targetColumn - 1; column >= targetColumn - radius; column--) {
                if (column >= 0 && column < matrix.get(targetRow).size()) {
                    matrix.get(targetRow).remove(column);
                }
            }
        }
        matrix.removeIf(List::isEmpty);
    }

    private static void fillMatrix(int rows, int columns, List<List<Integer>> matrix) {
        for (int row = 0; row < rows; row++) {
            List<Integer> listRow = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
                listRow.add((row * columns) + column + 1);
            }
            matrix.add(listRow);
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {

        for (int row = 0; row < matrix.size(); row++) {
            String rowToPrint = matrix.get(row)
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(rowToPrint);
        }
    }

}
