package TechFundamentals.OtherCourses.Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumEqualNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> list = Arrays
                .stream(reader.readLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                double sum = list.get(i) + list.get(i + 1);
                list.set(i, sum);
                list.remove(list.get(i + 1));
                i--;
            } else if (list.get(i + 1).equals(list.get(i + 2))) {
                double sum = list.get(i + 1) + list.get(i + 2);
                list.set(i + 1, sum);
                list.remove(list.get(i + 2));
                i--;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                double sum = list.get(i) + list.get(i + 1);
                list.set(i, sum);
                list.remove(list.get(i + 1));
                i--;
            }
        }
        for (Double num : list) {
            double floatingPoint = Math.ceil(num);
            if (num.equals(floatingPoint)) {
                System.out.printf("%.0f ", num);
            } else {
                System.out.printf("%.1f ", num);
            }
        }

    }
}
