package TechModule.JavaIntroductions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrongNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberAsString = reader.readLine();
        int number = Integer.parseInt(numberAsString);
        int sum = 0;

        for (int i = 0; i < numberAsString.length(); i++) {
            int factorial = 1;
            int digit = numberAsString.charAt(i) - '0';
            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            sum += factorial;
        }

        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
