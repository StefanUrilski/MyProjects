package forExam.C_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DC_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        double car = 0;
        double van = 0;
        double bus = 0;
        double bigBus = 0;
        double train = 0;
        double peoples = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.valueOf(reader.readLine());
            if (a <= 5) {
                car += a;
            } else if (a > 5 && a < 13) {
                van += a;
            } else if (a > 12 && a < 26) {
                bus += a;
            } else if (a > 25 && a < 41) {
                bigBus += a;
            } else {
                train += a;
            }
            peoples += a;
        }
        double car1 = car / peoples * 100;
        double van1 = van / peoples * 100;
        double bus1 = bus / peoples * 100;
        double bigBus1 = bigBus / peoples * 100;
        double train1 = train / peoples * 100;

        System.out.printf("%.2f", car1);
        System.out.println("%");
        System.out.printf("%.2f", van1);
        System.out.println("%");
        System.out.printf("%.2f", bus1);
        System.out.println("%");
        System.out.printf("%.2f", bigBus1);
        System.out.println("%");
        System.out.printf("%.2f", train1);
        System.out.println("%");

    }
}
