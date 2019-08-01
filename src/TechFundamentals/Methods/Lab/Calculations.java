package TechFundamentals.Methods.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // add, multiply, subtract, divide

        String command = reader.readLine();
        int a = Integer.valueOf(reader.readLine());
        int b = Integer.valueOf(reader.readLine());

        switch (command) {
            case "add":
                add(a, b);
                break;
            case "multiply":
                multiply(a, b);
                break;
            case "subtract":
                subtract(a, b);
                break;
            case "divide":
                divide(a, b);
                break;
        }
    }
    static void add (int a, int b) {
        System.out.println(a + b);
    }
    static void multiply (int a, int b) {
        System.out.println(a * b);
    }
    static void subtract (int a, int b) {
        System.out.println(a - b);
    }
    static void divide (int a, int b) {
        System.out.println(a / b);
    }
}
