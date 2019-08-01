package TechFundamentals.MapsLambdaAndStreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordSynonyms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        Map<String, List<String>> word = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String inputWord = reader.readLine();
            String inputSynonym= reader.readLine();
            word.putIfAbsent(inputWord, new ArrayList<>());
            word.get(inputWord).add(inputSynonym);
        }

        for (Map.Entry<String, List<String>> entry : word.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            System.out.println(String.join(", ", entry.getValue()));
        }
    }
}
