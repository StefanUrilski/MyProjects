package forExam.E_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FE_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char start = reader.readLine().charAt(0);
        char end = reader.readLine().charAt(0);
        char miss = reader.readLine().charAt(0);
        int count = 0;

        for (char i = start; i <= end; i++) {
            for (char j = start; j <= end ; j++) {
                for (char k = start; k <= end; k++) {
                    if (i != miss && j != miss && k != miss) {
                        System.out.print("" + i + j + k + " ");
                        count ++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
