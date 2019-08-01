package forExam.F_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BF_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int hourNeeded = Integer.valueOf(reader.readLine());
        int workersCount = Integer.valueOf(reader.readLine());
        int daysOfWork = Integer.valueOf(reader.readLine());

        int workedHours = workersCount * daysOfWork * 8;
        int diff = workedHours - hourNeeded;

        if (hourNeeded < workedHours) {
            System.out.println(diff + " hours left");
        } else {
            diff = Math.abs(diff);
            int penalty = diff * daysOfWork;
            System.out.println(diff + " overtime");
            System.out.println("Penalties: " + penalty);
        }

    }
}
