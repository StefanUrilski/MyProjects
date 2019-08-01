package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double eggPrice = Double.valueOf(reader.readLine()) / 100;
        double chickensFirstMonth = Double.valueOf(reader.readLine());
        double chickensBuySecondMonth = Double.valueOf(reader.readLine());
        double chickensBuyThirdMonth = Double.valueOf(reader.readLine());

        double month1 = chickensFirstMonth * 20;
        double month2 = (chickensFirstMonth + chickensBuySecondMonth) * 20;
        double month3 = (chickensFirstMonth + chickensBuySecondMonth + chickensBuyThirdMonth) * 20;
        double month1to3 = month1 + month2 + month3;
        double dispose = month1to3 - (month1to3 * 0.04);
        double overall = dispose * eggPrice;
        System.out.printf("Profit: %.0f Lv.",Math.floor(overall));

    }
}
