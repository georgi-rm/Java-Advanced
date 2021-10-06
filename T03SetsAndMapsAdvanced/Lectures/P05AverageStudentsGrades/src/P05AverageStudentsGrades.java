import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRecords = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int record = 0; record < numberOfRecords; record++) {
            String[] recordData = scanner.nextLine().split("\\s+");
            String studentName = recordData[0];
            double grade = Double.parseDouble(recordData[1]);

            students.putIfAbsent(studentName, new ArrayList<>());
            List<Double> grades = students.get(studentName);
            grades.add(grade);
            students.put(studentName, grades);
        }

        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            System.out.printf("%s -> ", student.getKey());
            student.getValue().forEach(v -> System.out.printf("%.2f ", v));

            List<Double> allGrades = student.getValue();

            double sumOfAllGrades = 0;
            for (Double grade : allGrades) {
                sumOfAllGrades += grade;
            }
            double average = sumOfAllGrades / allGrades.size();
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
