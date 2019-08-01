package TechFundamentals.Exams.DemoMidExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BakingMasterclass {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double budget = Double.valueOf(reader.readLine());
        int students = Integer.valueOf(reader.readLine());
        double flourPrice = Double.valueOf(reader.readLine());
        double eggPrice = Double.valueOf(reader.readLine());
        double apronPrice = Double.valueOf(reader.readLine());

        double flourSum = 0;
        for (int i = 1; i <= students; i++) {
            if (i % 5 == 0) {
                continue;
            }
            flourSum += flourPrice;
        }
        double apronsForStudents = students + (students * 0.2);
        apronsForStudents = Math.ceil(apronsForStudents);
        double apronsSum = apronPrice * apronsForStudents;

        double eggSum = (eggPrice * 10) * students;

        double totalPrice = eggSum + apronsSum + flourSum;

        if (budget >= totalPrice) {
            System.out.println(String.format("Items purchased for %.2f$.", totalPrice));
        } else {
            System.out.println(String.format("%.2f$ more needed.", totalPrice - budget));
        }

    }
}
