package Exams.FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (! "end".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            Pattern artist = Pattern.compile("^([A-Z][\\[' \\]*?\\[a-z\\]+]+)$");
            Pattern song = Pattern.compile("^([A-Z][\\[' \\]*?\\[A-Z\\]+]+)$");

            Matcher artistMatcher = artist.matcher(tokens[0]);
            Matcher songMatcher = song.matcher(tokens[1]);

            if (artistMatcher.matches() && songMatcher.matches()) {
                int key = tokens[0].length();
                input = encryptingString(input, key);
                System.out.println("Successful encryption: " + input);
            } else {
                System.out.println("Invalid input!");
            }
        }

    }

    private static String encryptingString(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            boolean upper = false;
            if (curr == 32 || curr == 39) {
                result.append(curr);
                continue;
            }
            if (curr == ':') {
                result.append('@');
                continue;
            }
            if (Character.isUpperCase(input.charAt(i))) { upper = true; }
            curr = (char) (curr + key);
            if (upper && curr > 90 || curr > 122) {
                curr = (char) (curr - 26);
            }
            result.append(curr);
        }
        return result.toString();
    }
}
