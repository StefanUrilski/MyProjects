package forExam.E_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AE_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double speed = Double.valueOf(reader.readLine());
        double firstTime = Double.valueOf(reader.readLine()) / 60;
        double secondTime = Double.valueOf(reader.readLine()) / 60;
        double thirdTime = Double.valueOf(reader.readLine()) / 60;

        double firstChange = speed * firstTime;
        double speedChange = speed + (speed * 0.1);
        double secondChange = speedChange * secondTime;
        double thirdChange = (speedChange - (speedChange * 0.05)) * thirdTime;
        double overall = firstChange + secondChange + thirdChange;
        System.out.printf("%.2f", overall);
    }
}
