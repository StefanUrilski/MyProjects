package Regex.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(^|(?<=\\s))([A-Za-z0-9]+)([\\._-]?)([A-Za-z0-9]*)@([A-Za-z]+)([-\\.]*)([A-Za-z]*)([-\\.]*)([A-Za-z]*)\\.([a-z]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
