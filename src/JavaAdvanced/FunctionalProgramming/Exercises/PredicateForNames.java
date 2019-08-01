package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<String, Integer> byLength = (e, size) -> e.length() <= size;

        int length = Integer.valueOf(reader.readLine());

        Arrays.stream(reader.readLine().split("\\s+"))
                .filter(e -> byLength.test(e, length))
                .forEach(System.out::println);

    }
}
