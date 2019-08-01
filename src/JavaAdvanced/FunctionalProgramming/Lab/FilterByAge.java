package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThen =
                (personAge, requestAge) -> personAge.getValue() >= requestAge;

        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThen =
                (personAge, requestAge) -> personAge.getValue() < requestAge;

        Consumer<Map.Entry<String, Integer>> printName = name -> System.out.println(name.getKey());

        Consumer<Map.Entry<String, Integer>> printAge = age -> System.out.println(age.getValue());

        Consumer<Map.Entry<String, Integer>> printNameAndAge =
                entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());

        int n = Integer.valueOf(reader.readLine());

        LinkedHashMap<String, Integer> peoples = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(", ");

            peoples.put(tokens[0], Integer.valueOf(tokens[1]));
        }

        String ageCriteria = reader.readLine();
        int age = Integer.valueOf(reader.readLine());
        String typeOfPrinting = reader.readLine();

        BiPredicate<Map.Entry<String, Integer>, Integer> wantedAge = olderThen;

        if (ageCriteria.equals("younger")) {
            wantedAge = youngerThen;
        }

        BiPredicate<Map.Entry<String, Integer>, Integer> finalWantedAge = wantedAge;

        Consumer<Map.Entry<String, Integer>> print = printNameAndAge;

        if (typeOfPrinting.equals("name")) {
            print = printName;
        } else if (typeOfPrinting.equals("age")) {
            print = printAge;
        }

        peoples.entrySet().stream()
                .filter(person -> finalWantedAge.test(person, age))
                .forEach(print);


    }
}
