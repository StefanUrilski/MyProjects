package forExam.A_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int m = Integer.valueOf(reader.readLine());
        int s = Integer.valueOf(reader.readLine());

        for (int i = m; i >= n; i--) {
            if (i % 2 == 0 && i % 3 == 0) {
                if (i == s) {
                    break;
                }
                System.out.print(i + " ");
            }
        }


    }
}
