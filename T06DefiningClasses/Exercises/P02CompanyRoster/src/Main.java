import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        while (inputLines-- > 0) {
            String[] commandParams = scanner.nextLine().split("\\s+");

            String employeeName = commandParams[0];
            double salary = Double.parseDouble(commandParams[1]);
            String position = commandParams[2];
            String departmentName = commandParams[3];
            Employee newEmployee;
            if (commandParams.length == 4) {
                newEmployee = new Employee(employeeName, salary, position, departmentName);
            } else if (commandParams.length == 5) {
                try {
                    int age = Integer.parseInt(commandParams[4]);
                    newEmployee = new Employee(employeeName, salary, position, departmentName, age);
                } catch (NumberFormatException e) {
                    String email = commandParams[4];
                    newEmployee = new Employee(employeeName, salary, position, departmentName, email);
                }
            } else {
                String email = commandParams[4];
                int age = Integer.parseInt(commandParams[5]);
                newEmployee = new Employee(employeeName, salary, position, departmentName, email, age);
            }
            departments.putIfAbsent(departmentName, new Department(departmentName));
            Department department = departments.get(departmentName);
            department.addEmployee(newEmployee);
        }

        departments.values().stream()
                .sorted((f, s) -> Double.compare(s.averageSalary(), f.averageSalary()))
                .limit(1)
                .forEach(d -> {
                    System.out.printf("Highest Average Salary: %s%n", d.getName());
                    d.getEmployees()
                            .stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(System.out::println);
                });
    }
}
