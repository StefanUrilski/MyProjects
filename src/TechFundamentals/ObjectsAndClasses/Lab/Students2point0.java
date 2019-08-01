package TechFundamentals.ObjectsAndClasses.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Students2point0 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input = reader.readLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String secondName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String town = tokens[3];
            boolean contains = true;
            for (Student student : students) {
                if (student.getFirstName().equals(firstName)
                        && student.getSecondName().equals(secondName)) {
                    student.setAge(age);
                    student.setHomeTown(town);
                    contains = false;
                    break;
                }
            }
            if (contains) {
                Student student = new Student(tokens[0], tokens[1], age, tokens[3]);
                students.add(student);
            }
            input = reader.readLine();
        }
        String city = reader.readLine();


        for (Student student : students) {
            if (student.getHomeTown().equals(city)) {
                System.out.println(String.format("%s %s is %d years old.",
                        student.getFirstName(), student.getSecondName(), student.getAge()));
            }
        }


    }
}
