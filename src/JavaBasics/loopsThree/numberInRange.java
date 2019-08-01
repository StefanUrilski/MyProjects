package loopsThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.valueOf(reader.readLine());
            if (n > 0 && n <= 100) {
                System.out.println("The number is: " + n);
                break;
            }
            System.out.println("Invalid number!");
        }

    }
}/*
        int n = Integer.valueOf(reader.readLine());
        while (n < 1 || n > 100) {
            System.out.println("Invalid number!");
            n = Integer.valueOf(reader.readLine());
        }
        System.out.println("The number is: " + n);
 */