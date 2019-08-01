package forExam.A_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.valueOf(reader.readLine());
        double y = Double.valueOf(reader.readLine());
        double z = Double.valueOf(reader.readLine());
        double workers = Double.valueOf(reader.readLine());

        double xGrapes = x * y;
        double wine = (0.4 * xGrapes) /2.5;

        if (z <= wine) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.", wine);
            System.out.println();
            double wineLeft = wine - z;
            double wineWorkers = wineLeft / workers;
            System.out.printf("%.0f liters left -> %.0f liters per person.", wineLeft, Math.ceil(wineWorkers));
        } else {
            double wineLeft = wine - z;
            wineLeft = Math.ceil(wineLeft);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.abs(wineLeft));
        }
    }
}
