package TechFundamentals.OtherCourses.Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
            // 8 2 2 8 2 2 3 7
        List<Integer> list = new ArrayList<>();
        List<Integer> counter = new ArrayList<>();
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            int count = 0;
            if (i == 0) {
                list.add(numbers.get(i));
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(i).equals(numbers.get(j))) {
                        count++;
                    }
                }
                counter.add(count);
            } else if (!numbers.get(i).equals(numbers.get(i - 1))) {
                list.add(numbers.get(i));
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(i).equals(numbers.get(j))) {
                        count++;
                    }
                }
                if (count == 0) {
                    count++;
                }
                counter.add(count);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " -> " + counter.get(i));
        }
    }
}
