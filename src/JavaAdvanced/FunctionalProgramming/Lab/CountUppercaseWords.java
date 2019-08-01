package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isUpper = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> text = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(isUpper)
                .collect(Collectors.toList());

        System.out.println(text.size());

        text.forEach(System.out::println);

    }
}
