package Regex.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("^%([A-Z][a-z]+)%[^\\|\\$\\%\\.]*?\\<(\\w+)>[^\\|\\$\\%\\.]*?\\|(\\d+)\\|[^\\|\\$\\%\\.]*?(\\d+\\.\\d+|\\d+)\\$$");
        double sum = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                double totalAmount = Integer.parseInt(matcher.group(3)) * Double.parseDouble(matcher.group(4));
                System.out.printf("%s: %s - %.2f%n", matcher.group(1), matcher.group(2), totalAmount);
                sum += totalAmount;
            }
            input = reader.readLine();
        }
        System.out.printf("Total income: %.2f", sum);

    }
}
