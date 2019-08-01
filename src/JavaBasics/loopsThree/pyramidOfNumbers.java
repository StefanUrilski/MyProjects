package loopsThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pyramidOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        int num = 1;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                if (j > 1) {
                    System.out.print(" ");
                }
                System.out.print(num);
                num++;
                if (num > a) {
                    break;
                }
            }
            System.out.println();
            if (num > a) {
                break;
            }
        }
    }
}
