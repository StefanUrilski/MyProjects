package forExam.F_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FF_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.valueOf(reader.readLine());
        int a2 = Integer.valueOf(reader.readLine());
        int a3 = Integer.valueOf(reader.readLine());

        for (int i = 1; i <= a1; i++) {
            for (int j = 1; j <= a2; j++) {
                for (int k = 1; k <= a3; k++) {
                    if (i % 2 == 0 && k % 2 == 0) {
                        if (j == 2 || j == 3 || j == 5 || j == 7) {
                            System.out.printf("%d %d %d\n", i, j, k);
                        }
                    }

                }
            }
        }
        
        
        /*
        int start = Integer.valueOf(reader.readLine());
        int finish = Integer.valueOf(reader.readLine());
        int magicNumber = Integer.valueOf(reader.readLine());

        int counter = 0;
        for (int i = start; i <= finish; i++) {
            for (int j = start; j <= finish; j++) {
                counter ++;
                if (i + j == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, magicNumber);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", counter, magicNumber);
        
        */
    }
}
