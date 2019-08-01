package Regex.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String names = reader.readLine();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Pattern otherPattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");

        Matcher matcher = pattern.matcher(names);
        while (matcher.find()) {
                System.out.print(matcher.group() + " ");
        }

    }
}
