package loopsThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class checkPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());

        if (a == 1 || a == -1 || a == 0 || a == -11) {
            System.out.println("Not Prime");
            return;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                System.out.println("Not Prime");
                return;
            }
        }
        System.out.println("Prime");
    }
}
