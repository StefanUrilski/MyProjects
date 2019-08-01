package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            switch (input[0]) {
                case "1":
                    int numb = Integer.parseInt(input[1]);
                    numbers.push(numb);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    int max = Collections.max(numbers);
                //    int max = numbers.stream().max(Integer::compareTo).get();
                    System.out.println(max);
                    break;
            }

        }
    }
}
