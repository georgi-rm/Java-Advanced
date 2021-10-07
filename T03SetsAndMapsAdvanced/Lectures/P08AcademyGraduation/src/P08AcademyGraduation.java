import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();

            students.putIfAbsent(name, new ArrayList<>());

            List<Double> grades = students.get(name);

            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .forEach(grades::add);
            students.put(name, grades);
        }

        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            double sum = 0;
            for (Double grade : student.getValue()) {
                sum += grade;
            }
            double average = sum / student.getValue().size();
            System.out.println(student.getKey() + " is graduated with " + average);
        }

    }
}
