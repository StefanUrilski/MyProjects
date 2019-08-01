package forExam.D_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BD_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cupsOrder = Integer.valueOf(reader.readLine());
        int workerCount = Integer.valueOf(reader.readLine());
        int daysOfWork = Integer.valueOf(reader.readLine());

        double hoursOfWork = workerCount * daysOfWork * 8;
        double readyCups = hoursOfWork / 5;
        readyCups = Math.floor(readyCups);

        if (cupsOrder > readyCups) {
            System.out.printf("Losses: %.2f", (cupsOrder - readyCups) * 4.2);
        } else {
            System.out.printf("%.2f extra money", (readyCups - cupsOrder) * 4.2);
        }
    }
}
