package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String basicsName = reader.readLine();
        int numberOfStudents = Integer.valueOf(reader.readLine());
        double results = 0;
        int weak = 0;
        int excellent = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            double grades = Double.valueOf(reader.readLine());
            if (grades < 3) {
                results += 2;
                weak ++;
            } else if (grades > 6) {
                results += 6;
            } else {
                results += grades;
            }
            if (grades >= 5.5) {
                excellent ++;
            }
        }
        double average = results / numberOfStudents;

        switch (basicsName) {
            case "Programming basics":
                average += 0.3;
                break;
            case "Photoshop basics":
                average += 0.2;
                break;
            case "AdWords basics":
                average += 0.4;
                break;
                default:
                    System.out.println(basicsName + " is invalid course name!");
                    return;
        }

        if (average > 6) {
            average = 6;
        }
        System.out.printf("%s average score: %.2f \n", basicsName, average);
        System.out.println("Weak results: " + weak);
        System.out.println("Excellent results: " + excellent);
    }
}

