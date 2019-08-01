package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    BiPredicate<Integer, Integer> divisible = (x, y) -> x % y != 0;

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int divider = Integer.valueOf(reader.readLine());

        numbers = numbers.stream().filter(curr -> divisible.test(curr, divider))
                .collect(Collectors.toList());

        int[] array = numbers.stream().mapToInt(Integer::intValue).toArray();


        IntStream.rangeClosed(1, array.length)
                .mapToObj(i -> array[array.length - i])
                .forEach(e -> System.out.print(e + " "));

//        for (int i = numbers.getRows() - 1; i >= 0; i--) {
//            System.out.print(numbers.get(i) + " ");
//        }
    }
}