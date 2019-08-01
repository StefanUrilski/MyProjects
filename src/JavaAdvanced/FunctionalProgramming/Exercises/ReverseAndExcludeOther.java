package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ReverseAndExcludeOther {
    public static void main(String[] args) throws IOException {
        BiPredicate<Integer, Integer> divisible = (x, y) -> x % y != 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divider = Integer.valueOf(reader.readLine());

        Collections.reverse(numbers);

        numbers.stream().filter(e -> divisible.test(e, divider)).forEach(e -> System.out.print(e + " "));

    }
}
