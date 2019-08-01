package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<Integer, Integer> add = x -> x + 1;
        UnaryOperator<List<Integer>> adding = list -> list.stream().map(add).collect(Collectors.toList());

        Function<Integer, Integer> multiply = x -> x * 2;
        UnaryOperator<List<Integer>> multiplying = list -> list.stream().map(multiply).collect(Collectors.toList());

        Function<Integer, Integer> subtract = x -> x - 1;
        UnaryOperator<List<Integer>> subtracting = list -> list.stream().map(subtract).collect(Collectors.toList());

        Consumer<Integer> print = x -> System.out.print(x + " ");

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        String line = reader.readLine();

        boolean isPrinted = false;

        while (!line.equals("end")) {

            switch (line) {
                case "add":
                    numbers = adding.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplying.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtracting.apply(numbers);
                    break;
                default:
                    numbers.forEach(print);
                    System.out.println();
                    isPrinted = true;
                    break;
            }

            line = reader.readLine();
        }

        if (!isPrinted) {
            numbers.forEach(print);
        }

    }
}
