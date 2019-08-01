package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> vat = n -> 1.2 * n;

        System.out.println("Prices with VAT:");
        Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble)
                .map(vat)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
