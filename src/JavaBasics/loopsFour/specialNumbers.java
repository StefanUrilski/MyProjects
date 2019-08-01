package loopsThree.forExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class specialNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (a % i == 0 && a % j == 0 && a % k == 0 && a % l == 0){
                            System.out.print("" + i + j + k + l + " ");
                        }
                    }
                }
            }
        }
    }
}
