package forExam.D_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CD_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double budget = Double.valueOf(reader.readLine());
        String season = reader.readLine();
        double price = 0;
        String place = "";

        if (budget <= 1000) {
            place = "Camp";
            if (season.equals("Summer")) {
                price += budget * 0.65;
            } else {
                price += budget * 0.45;
            }
        } else if (budget <= 3000) {
            place = "Hut";
            if (season.equals("Summer")) {
                price += budget * 0.8;
            } else {
                price += budget * 0.6;
            }
        } else {
            place = "Hotel";
            price += budget * 0.9;
        }

        if (season.equals("Summer")) {
            System.out.printf("Alaska - %s - %.2f", place, price);
        } else {
            System.out.printf("Morocco - %s - %.2f", place, price);
        }

    }
}
