package forExam.D_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FD_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.valueOf(reader.readLine());
        int end = Integer.valueOf(reader.readLine());
        int magicNumber = Integer.valueOf(reader.readLine());
        int count = 0;

        for (int i = start; i >= end; i--) {
            for (int j = start; j >= end; j--) {
                count++;
                if (i + j == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, i, j, magicNumber);
                    return;
                }
            }

        }
        System.out.printf("%d combinations - neither equals %d", count, magicNumber);
    }
}
