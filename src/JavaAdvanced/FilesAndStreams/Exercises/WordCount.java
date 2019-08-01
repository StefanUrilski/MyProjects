package FilesAndStreams.Exercises;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects\\src" +
                "\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Exercises\\";

        String witchWords = path + "words.txt";
        String fileIn = path + "text.txt";
        String fileOut = path + "results.txt";
        FileInputStream inputStream = new FileInputStream(witchWords);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String[] words = reader.readLine().split("\\s+");
        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        for (String word : words) {
            wordsCount.put(word, 0);
        }

        inputStream = new FileInputStream(fileIn);
        reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        while (line != null) {
            String[] tokens = line.split("\\s+");
            for (String word : tokens) {
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }

            }

            line = reader.readLine();
        }
        inputStream.close();

        FileWriter writer = new FileWriter(fileOut);

        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            writer.write(entry.getKey() + " - " + entry.getValue() + System.lineSeparator());
        }
        writer.close();
    }
}
