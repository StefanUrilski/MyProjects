package Regex.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        double totalAmount = 0;
        System.out.println("Bought furniture:");

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile("^>>(.*)<<(\\d+\\.?\\d+)!(\\d+)\\b");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furniture = matcher.group(1);
                double prices = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));
                totalAmount += prices * quantity;
                System.out.println(furniture);
            }
            input = reader.readLine();
        }

        System.out.printf("Total money spend: %.2f", totalAmount);

    }
}
