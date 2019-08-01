package forExam.C_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AC_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double mackerelPriceKG = Double.valueOf(reader.readLine());
        double spratPriceKG = Double.valueOf(reader.readLine());
        double palmwoodKG = Double.valueOf(reader.readLine());  //
        double scadKG = Double.valueOf(reader.readLine());      //
        double clamKG = Double.valueOf(reader.readLine()) * 7.5;      //

        double palmwoodPrice = mackerelPriceKG + (mackerelPriceKG * 0.6);
        double scadPrice = spratPriceKG + (spratPriceKG * 0.8);

        double palmwoodOrder = palmwoodKG * palmwoodPrice;
        double scadOrder = scadPrice * scadKG;

        double sum = clamKG + palmwoodOrder + scadOrder;

        System.out.printf("%.2f", sum);
    }
}
