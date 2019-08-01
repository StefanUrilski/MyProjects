package Regex.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();


        for (int i = 0; i < lines; i++) {
            String message = reader.readLine();
            Pattern pattern = Pattern.compile("[starSTAR]");
            Matcher matcher = pattern.matcher(message);
            int decryptionKey = 0;
            while (matcher.find()) {
                decryptionKey++;
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                decryptedMessage.append((char)(message.charAt(j) - decryptionKey));
            }
            pattern = Pattern.compile("@([A-Za-z]+)[^@\\-!:>]*:(\\d+)[^@\\-!:>]*!(A|D)![^@\\-!:>]*->(\\d+)");
            matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                if (matcher.group(3).equals("A")) {
                    attacked.add(matcher.group(1));
                } else {
                    destroyed.add(matcher.group(1));
                }
            }
        }
        Collections.sort(attacked);
        Collections.sort(destroyed);
        System.out.printf("Attacked planets: %d%n", attacked.size());
        for (String s : attacked) {
            System.out.printf("-> %s%n", s);
        }
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        for (String s : destroyed) {
            System.out.printf("-> %s%n", s);
        }

    }
}
