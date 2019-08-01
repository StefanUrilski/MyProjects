package forExam.A_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double budget = Double.valueOf(reader.readLine());
        String category = reader.readLine();
        int size = Integer.valueOf(reader.readLine());
        double moneyLeft = 0;
        moneyLeft += budget;
        if (size <= 4) {
            moneyLeft -= (moneyLeft * 0.75);
        } else if (size <= 9) {
            moneyLeft -= (moneyLeft * 0.6);
        } else if (size <= 24) {
            moneyLeft -= (moneyLeft * 0.5);
        } else if (size <= 49) {
            moneyLeft -= (moneyLeft * 0.4);
        } else {
            moneyLeft -= (moneyLeft * 0.25);
        }
        switch (category) {
            case "VIP":
                moneyLeft -= (499.99 * size);
                break;
            case "Normal":
                moneyLeft -= (249.99 * size);
                break;
        }
        if (moneyLeft > 0) {
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(moneyLeft));
        }

    }
}
