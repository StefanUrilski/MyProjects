package forExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for (int i = 0; i < n; i++) {
            int a = Integer.valueOf(reader.readLine());
            if (a % 2 == 0) { p1 ++; }
            if (a % 3 == 0) { p2 ++; }
            if (a % 4 == 0) { p3 ++; }
        }

        p1 = (p1 / n) * 100;
        p2 = (p2 / n) * 100;
        p3 = (p3 / n) * 100;
        System.out.printf("%.2f", p1);
        System.out.println("%");
        System.out.printf("%.2f", p2);
        System.out.println("%");
        System.out.printf("%.2f", p3);
        System.out.println("%");


    }
}
