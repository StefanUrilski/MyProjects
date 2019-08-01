package TechFundamentals.MapsLambdaAndStreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountCharsInString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();

        Map<Integer, Integer> counter = new TreeMap<>();
        for (int number : numbers) {
            if (!counter.containsKey(number)) {
                counter.put(number, 0);
            }
            counter.put(number, counter.get(number) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            System.out.printf("%d -> %d",entry.getKey(),entry.getValue());
            System.out.println();
        }


    }
}
