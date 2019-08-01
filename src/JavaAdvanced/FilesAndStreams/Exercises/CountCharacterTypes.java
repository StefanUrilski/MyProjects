package FilesAndStreams.Exercises;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Stefan\\IdeaProjects\\MyProjects\\src" +
                "\\JavaAdvanced\\FilesAndStreams\\Java Stream\\Exercises\\";

        String fileIn = path + "input.txt";
        String fileOut = path + "\\Out\\CountCharTypes.txt";

        FileInputStream inputStream = new FileInputStream(fileIn);
        FileWriter outputStream = new FileWriter(fileOut);

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> punctuations = new HashSet<>(Arrays.asList('!', ',', '.', '?'));

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        int countVowels = 0;
        int countPunctuations = 0;
        int countOther = 0;
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char curr = line.charAt(i);
                if (vowels.contains(curr)) {
                    countVowels++;
                } else if (punctuations.contains(curr)) {
                    countPunctuations++;
                } else if (curr != ' ') {
                    countOther++;
                }
            }

            line = reader.readLine();
        }

        outputStream.write("Vowels: " + countVowels + System.lineSeparator());
        outputStream.write("Consonants: " + countOther + System.lineSeparator());
        outputStream.write("Punctuation: " + countPunctuations + System.lineSeparator());

        outputStream.close();
    }
}
