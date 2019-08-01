package ZForExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SoftUniBarIncome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        double sum = 0;
        while (! "end of shift".equals(input = reader.readLine())) {
            if (orderValidation(input)) {
                String name = input.substring(input.indexOf("%") + 1, input.lastIndexOf("%"));
                String product = input.substring(input.indexOf("<") + 1, input.lastIndexOf(">"));
                String amountAsStr = input.substring(input.indexOf("|") + 1, input.lastIndexOf("|"));
                int index = indexOfTheMoney(input);
                String priceAsStr = input.substring(index, input.lastIndexOf("$"));
                double amount = Double.valueOf(amountAsStr);
                double price = Double.valueOf(priceAsStr);
                System.out.println(String.format("%s: %s - %.2f", name, product, price * amount));
                sum += price * amount;
            }
        }
        System.out.println(String.format("Total income: %.2f", sum));
    }

    private static boolean orderValidation(String order) {
        if (order.indexOf("%") == order.lastIndexOf("%")) {
            return false;
        }
        if (! Character.isUpperCase(order.charAt(order.indexOf("%") + 1))) {
            return false;
        }
        for (int i = order.indexOf("%") + 2; i < order.lastIndexOf("%"); i++) {
            if (Character.isUpperCase(order.charAt(i))) {
                return false;
            }
        }
        if (! order.contains("<") || ! order.contains(">")) {
            return false;
        }
        if (order.indexOf("|") == order.lastIndexOf("|")) {
            return false;
        }
        if (order.indexOf("%") > order.indexOf("<") || order.indexOf(">") > order.indexOf("|") || order.indexOf("|") > order.indexOf("$")) {
            return false;
        }
        return order.contains("$");
    }

    private static int indexOfTheMoney(String input) {
        int startIndex = input.lastIndexOf("|");
        for (int i = startIndex; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                return i;
            }
        }
        return input.length() - 2;
    }
}
