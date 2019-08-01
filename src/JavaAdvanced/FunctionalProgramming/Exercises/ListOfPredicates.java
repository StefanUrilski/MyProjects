package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<Integer, HashSet<Integer>> divide = (e, set) -> {
            for (Integer i : set) {
                if (e % i != 0) {
                    return false;
                }
            }
            return true;
        };

        int n = Integer.valueOf(reader.readLine());

        List<Integer> numbs = IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toList());

        HashSet<Integer> dividers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        numbs.stream().filter(e -> divide.test(e, dividers)).forEach(e -> System.out.print(e + " "));

    }
}
