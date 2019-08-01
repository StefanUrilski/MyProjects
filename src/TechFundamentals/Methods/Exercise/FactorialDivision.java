package TechFundamentals.Methods.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double first = Double.valueOf(reader.readLine());
        double second = Double.valueOf(reader.readLine());

        factorialDivision(first, second);
    }

    private static double factorialCalc(double a) {
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        return result;
    }

    private static void factorialDivision(double a, double b) {
        double firstResult = factorialCalc(a);
        double secondResult = factorialCalc(b);
        double result = firstResult / secondResult;
        System.out.printf("%.2f", result);
    }
}
