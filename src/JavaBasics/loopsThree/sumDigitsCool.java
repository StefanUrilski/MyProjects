package loopsThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumDigitsCool {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        int sum = 0;

        do {
            sum += (a%10);
            a /= 10;
        }while (a > 0);
        System.out.println(sum);
    }
}
