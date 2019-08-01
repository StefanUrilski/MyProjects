package TechFundamentals.OtherCourses.Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SquareNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int curr = numbers.get(i);
            double square = Math.sqrt(curr);
            double numb = (int)square;
            if (numb == square){
                list.add(curr);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int index : list) {
            System.out.print(index + " ");
        }
    }
}
