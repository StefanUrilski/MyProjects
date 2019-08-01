package TechFundamentals.MapsLambdaAndStreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputWords = reader.readLine().toLowerCase().split("\\s+");
        Map<String, Integer> words = new LinkedHashMap<>();

        for (String inputWord : inputWords) {
            words.putIfAbsent(inputWord, 0);
            words.put(inputWord, words.get(inputWord) + 1);
        }
        List<String> temp = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            int value = entry.getValue();
            if (value % 2 != 0){
                temp.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", temp));

    }
}
