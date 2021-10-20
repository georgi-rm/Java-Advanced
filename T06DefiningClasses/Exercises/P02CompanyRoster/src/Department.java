import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
    }

    public double averageSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }

        return sum / employees.size();
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
