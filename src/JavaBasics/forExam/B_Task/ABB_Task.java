package forExam.B_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABB_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double workDaysM = Double.valueOf(reader.readLine());
        double moneyForDay = Double.valueOf(reader.readLine());
        double exchangeRate = Double.valueOf(reader.readLine());

        double forMonth = workDaysM * moneyForDay;
        double forYear = forMonth * 12 + forMonth * 2.5;
        double taxes = forYear - (forYear * 0.25);
        double forYearBG = taxes * exchangeRate;
        double overAll = forYearBG / 365;
        System.out.printf("%.2f", overAll);

    }
}
