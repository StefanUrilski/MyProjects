package TechFundamentals.ObjectsAndClasses.Exercise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsNew {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentList = new ArrayList<>();
        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String first = tokens[0];
            String last = tokens[1];
            double grade = Double.valueOf(tokens[2]);
            Student student = new Student(first, last, grade);
            studentList.add(student);
        }
        studentList.stream().sorted((g1, g2) -> Double.compare(g2.getGrade(), g1.getGrade()))
                .forEach(e -> System.out.printf("%s %s: %.2f%n", e.getFirstName(), e.getSecondName(), e.getGrade()));

    }
}

class Student {
    private String firstName;
    private String secondName;
    private Double grade;

    public Student(String firstName, String secondName, double grade) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setGrade(grade);
    }

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

}