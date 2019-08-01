package DefiningClasses.Exercises.CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        HashMap<String, Department> departments = new HashMap<>();
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.valueOf(tokens[1]);
            String departmentName = tokens[3];

            Employee employee = new Employee(name, salary);

            if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    employee.setEmail(tokens[4]);
                } else {
                    employee.setAge(Integer.valueOf(tokens[4]));
                }
            } else if (tokens.length == 6) {
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.valueOf(tokens[5]));
            }

            departments.putIfAbsent(departmentName, new Department(departmentName));

            departments.get(departmentName).getEmployee().add(employee);

        }

        departments.entrySet().stream()
                .sorted((f, s) -> Double.compare(s.getValue().getAverage(),f.getValue().getAverage()))
                .findFirst()
                .stream()
                .forEach(d -> {
                    System.out.println("Highest Average Salary: " + d.getKey());
                    d.getValue().getEmployee().stream()
                            .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                            .forEach(System.out::println);
                });

    }
}
