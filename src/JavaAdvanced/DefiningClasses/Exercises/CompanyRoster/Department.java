package DefiningClasses.Exercises.CompanyRoster;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployee() {
        return this.employees;
    }

    public double getAverage() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average().getAsDouble();
    }

}
