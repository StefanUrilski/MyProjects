package forExam.E_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CE_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chrysanthemumCount = Integer.valueOf(reader.readLine());
        int rosesCount = Integer.valueOf(reader.readLine());
        int tulipCount = Integer.valueOf(reader.readLine());
        String season = reader.readLine();
        String holiday = reader.readLine();

        double chrysanthemum = 0;
        double roses = 0;
        double tulip = 0;

        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemum += 2;
                roses += 4.1;
                tulip += 2.5;
                break;
            case "Autumn":
            case "Winter":
                chrysanthemum += 3.75;
                roses += 4.5;
                tulip += 4.15;
        }
        double chrysanthemumsPrice = chrysanthemum * chrysanthemumCount;
        double rosesPrice = roses * rosesCount;
        double tulipsPrice = tulip * tulipCount;
        double overall = chrysanthemumsPrice + rosesPrice + tulipsPrice;

        if (holiday.equals("Y")) {
            overall += overall * 0.15;
        }
        if (season.equals("Spring")) {
            if (tulipCount > 7) {
                overall -= overall * 0.05;
            }
        }else  if (season.equals("Winter")) {
            if (rosesCount >= 10) {
                overall -= overall * 0.1;
            }
        }
        int allCount = rosesCount + tulipCount + chrysanthemumCount;
        if (allCount > 20) {
            overall -= overall * 0.2;
        }
        System.out.printf("%.2f", overall + 2);

    }
}