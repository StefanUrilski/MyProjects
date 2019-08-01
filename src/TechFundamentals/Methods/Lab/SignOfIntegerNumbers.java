package TechFundamentals.Methods.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignOfIntegerNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.valueOf(reader.readLine());
        System.out.printf("The number %d ", inputNumber);
        checkFromZero(inputNumber);
    }
    static void checkFromZero (int number){
        if (number > 0) {
            System.out.println("is positive.");
        } else if (number < 0) {
            System.out.println("is negative.");
        } else {
            System.out.println("is zero.");
        }
    }
}
