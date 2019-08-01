package forExam.B_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BBB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int hoursNeeded = Integer.valueOf(reader.readLine());
        int daysTheyGot = Integer.valueOf(reader.readLine());
        int employOvertime = Integer.valueOf(reader.readLine());

        double workTraining = daysTheyGot - (daysTheyGot * 0.1);
        double workHours = workTraining * 8;
        int overtime = employOvertime * (2 * daysTheyGot);
        double allHours = workHours + overtime;
        double hours = allHours - hoursNeeded;
        if (hours >= 0){
            System.out.printf("Yes!%.0f hours left.", Math.floor(hours));
        } else {
            hours = Math.abs(hours);
            System.out.printf("Not enough time!%.0f hours needed.", Math.ceil(hours));
        }
    }
}
