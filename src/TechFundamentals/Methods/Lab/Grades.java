package TechFundamentals.Methods.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double grades = Double.valueOf(reader.readLine());
        checkingGrades(grades);

    }
    static void checkingGrades (double number) {
        if (number < 3) {
            System.out.println("Fail");
        } else if (number < 3.5) {
            System.out.println("Poor");
        } else if (number < 4.5) {
            System.out.println("Good");
        } else if (number < 5.5) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }
    }
}

