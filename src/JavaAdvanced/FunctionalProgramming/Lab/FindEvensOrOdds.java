package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<Integer> odd = numb -> numb % 2 != 0;
        Predicate<Integer> even = numb -> numb % 2 == 0;

        String[] bounder = reader.readLine().split("\\s+");

        int startNumb = Integer.valueOf(bounder[0]);
        int endNumb = Integer.valueOf(bounder[1]);

        List<Integer> numbers = IntStream
                .range(startNumb, endNumb + 1)
                .boxed()
                .collect(Collectors.toList());

        String types = reader.readLine();

        Predicate<Integer> type = odd;

        if (types.equals("even")) {
            type = even;
        }

        numbers.stream()
                .filter(type)
                .forEach(e-> System.out.print(e + " "));



    }
}
