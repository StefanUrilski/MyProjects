package TechFundamentals.OtherCourses.Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> numbers = Arrays
                .stream(reader.readLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            double numb = numbers.get(i);
            if (update(numb)) {
                System.out.print(numbers.get(i));
                if (numbers.size() > i + 1) {
                    System.out.print(" <= ");
                }
            } else {
                System.out.printf("%.0f", numbers.get(i));
                if (numbers.size() > i + 1) {
                    System.out.print(" <= ");
                }
            }

        }
    }

    static boolean update (double number) {
        if (number == (int) number) {
            return false;
        } else {
            return true;
        }
    }
}