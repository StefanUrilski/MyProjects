package loopsThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class evenPowersOfTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int num = 1;
        for (int i = 0; i <= n; i+=2) {
            System.out.println(num);
            num *= 4;
        }
    }
}
