package forExam.A_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double bitcoin = Double.valueOf(reader.readLine()) * 1168;
        double juan = Double.valueOf(reader.readLine()) * 0.15 * 1.76;
        double commission = Double.valueOf(reader.readLine()) / 100;
        double sum = (bitcoin + juan) / 1.95;
        double total = sum - (sum * commission);

        System.out.printf("%.2f",total);

    }
}
