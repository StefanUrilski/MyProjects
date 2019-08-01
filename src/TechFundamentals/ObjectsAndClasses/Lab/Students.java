package TechFundamentals.ObjectsAndClasses.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<Student> pupils = new ArrayList<>();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            int age = Integer.valueOf(tokens[2]);
            Student student = new Student(tokens[0], tokens[1], age, tokens[3]);
            pupils.add(student);
            input = reader.readLine();
        }
        String city = reader.readLine();
        for (Student student : pupils) {
            if (student.getHomeTown().equals(city)) {
                System.out.println(String.format("%s %s is %d years old.",
                        student.getFirstName(), student.getSecondName(), student.getAge()));
            }
        }

    }
}

class Student {
    private String firstName;
    private String secondName;
    private int age;
    private String homeTown;
    private Double grade;

    public Student(String firstName, String secondName, int age, String homeTown) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setAge(age);
        this.setHomeTown(homeTown);
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
    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

}