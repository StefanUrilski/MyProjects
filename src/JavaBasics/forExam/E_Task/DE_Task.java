package forExam.E_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DE_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        double average2 = 0;
        double average3 = 0;
        double average4 = 0;
        double average5 = 0;
        double grades = 0;
        double average = 0;

        for (int i = 0; i < n; i++) {
            double a = Double.valueOf(reader.readLine());
            if (a < 3) {
                average2 ++;
            } else if (a >= 3 && a < 4) {
                average3 ++;
            } else if (a >= 4 && a < 5) {
                average4 ++;
            } else {
                average5 ++;
            }
            grades += a;
        }

        average = grades / n;

        average2 = (average2 / n) * 100;
        average3 = (average3 / n) * 100;
        average4 = (average4 / n) * 100;
        average5 = (average5 / n) * 100;

        System.out.printf("Top students: %.2f", average5);
        System.out.println("%");
        System.out.printf("Between 4.00 and 4.99: %.2f", average4);
        System.out.println("%");
        System.out.printf("Between 3.00 and 3.99: %.2f", average3);
        System.out.println("%");
        System.out.printf("Fail: %.2f", average2);
        System.out.println("%");
        System.out.printf("Average: %.2f", average);

    }
}
