package forExam.C_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CC_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberAdults = Integer.valueOf(reader.readLine());
        int numberStudents = Integer.valueOf(reader.readLine());
        double nights = Double.valueOf(reader.readLine()) * 82.99;
        String transport = reader.readLine();
        int peoples = numberAdults + numberStudents;

        double priceAdults = 0;
        double priceStudents = 0;

        switch (transport) {
            case "train":
                priceAdults += 24.99;
                priceStudents += 14.99;
                if (peoples >= 50){
                    priceAdults -= (priceAdults * 0.5);
                    priceStudents -= (priceStudents * 0.5);
                }
                break;
            case "bus":
                priceAdults += 32.50;
                priceStudents += 28.50;
                break;
            case "boat":
                priceAdults += 42.99;
                priceStudents += 39.99;
                break;
            case "airplane":
                priceAdults += 70;
                priceStudents += 50;
                break;
            default:
                break;
        }

        double travelSumAdults = priceAdults * numberAdults;
        double travelSumStudents = priceStudents * numberStudents;

        double travelSum = (travelSumAdults + travelSumStudents) * 2;
        double travelSumAll = travelSum + nights;

        double overall = travelSumAll + (travelSumAll * 0.1);

        System.out.printf("%.2f", overall);

    }
}
