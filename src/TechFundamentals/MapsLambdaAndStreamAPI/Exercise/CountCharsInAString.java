package MapsLambdaAndStreamAPI.Exercise;

import javax.naming.directory.SchemaViolationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharsInAString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("");
        Map<String, Integer> countChars = new LinkedHashMap<>();
        for (String word : words) {
            if (!word.equals(" ")) {
                if(!countChars.containsKey(word)){
                    countChars.put(word, 0);
                }
                countChars.put(word, countChars.get(word) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countChars.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }
}
