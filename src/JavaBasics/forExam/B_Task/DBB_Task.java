package forExam.B_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.valueOf(reader.readLine());
        int doc = 7;
        int treated = 0;
        int untreated = 0;
        for (int i = 1; i <= days; i++) {
            int patients = Integer.valueOf(reader.readLine());
            if (i % 3 == 0) {
                if (untreated > treated) {
                    doc++;
                }
            }
            if (patients > doc) {
                treated += doc;
                untreated += (patients - doc);
            } else {
                treated += patients;
            }
        }
        System.out.printf("Treated patients: %d.\n", treated);
        System.out.printf("Untreated patients: %d.", untreated);

    }
}
