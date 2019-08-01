package Exams.DemoFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("([d-z]+#?\\{?}?\\|?)+");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("This is not the book you are looking for.");
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            int curr = input.charAt(i);
            /*
            if (!(curr > 99 && curr < 126 || curr == 35 || curr == 32)){
                System.out.println("This is not the book you are looking for.");
                return;
            }
            */
            int curr2 = input.charAt(i) - 3;
            char current = (char) curr2;
            builder.append(current);
        }
        input = reader.readLine();
        String[] tokens = input.split(" ");
        String text = builder.toString();
        while (text.contains(tokens[0])) {
            text = text.replace(tokens[0], tokens[1]);
        }
        System.out.println(text);

    }
}
