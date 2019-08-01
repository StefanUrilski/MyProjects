package TechFundamentals.OtherCourses.Lists.Exerscise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoundingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String read = reader.readLine();
        String[] input = read.split(" ");
        double[] numbers = new double[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(input[i]);
        }
       // rounding(numbers);
        for (double number : numbers) {
            System.out.printf(number + " => %.0f%n", number);
        }/*
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            System.out.printf(" => %.0f%n", numbers[i]);
        }*/
    }

    private static void rounding(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                numbers[i] = Math.round(numbers[i]);
            } else {
                numbers[i] = Math.abs(numbers[i]);
                numbers[i] = Math.round(numbers[i]);
                numbers[i] = - (numbers[i]);
            }
        }
    }
}
