package loopsThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class evenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                int a = Integer.valueOf(reader.readLine());
                if (a % 2 == 0) {
                    System.out.println("Even number entered: " + a);
                    break;
                }
                System.out.println("The number is not even.");
            } catch (Exception a) {
                System.out.println("Invalid number!");
            }
        }

    }
}
