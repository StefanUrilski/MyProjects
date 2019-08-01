package MapsLambdaAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class lambdaSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::valueOf).toArray();

        Map<Double, Integer> counter = new TreeMap<>();

        for (double number : numbers) {
            counter.putIfAbsent(number, 0);
            counter.put(number, counter.get(number) + 1);
        }

        DecimalFormat df = new DecimalFormat("#.#######");

        // sorting with lambda expressions
        counter.entrySet().stream()
                .sorted((es1, es2) -> {
                    int value1 = es1.getValue();
                    int value2 = es2.getValue();
                    // compare es2 to es1 for descending order of sort
                    int valueCompare = Integer.compare(value2, value1);
                    // if bout are equals, compare the keys -> key2 to key1
                    if (valueCompare == 0) {
                        double key1 = es1.getKey();
                        double key2 = es2.getKey();
                        return Double.compare(key2, key1);
                    }
                    return valueCompare;
                })
                // print to console
                .forEach(pair -> {
                        String number = df.format(pair.getKey());
                        int count = pair.getValue();
                        System.out.printf("%s -> %d%n", number, count);
                });

    }
}
