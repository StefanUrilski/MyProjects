package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double Tedi = Double.valueOf(reader.readLine());
        double Silveto = Double.valueOf(reader.readLine());
        double Radi = Double.valueOf(reader.readLine());
        double Asen = Double.valueOf(reader.readLine());

        double TedisPoints = Tedi - (Tedi * 0.1);
        double SilvetosPoints = Silveto - (Silveto * 0.05);
        double TedisAndSilvetosPoints = TedisPoints + SilvetosPoints;
        double RadisAndAsens = Radi + Asen;
        double RadisAndAsensPoints = RadisAndAsens - (RadisAndAsens / 6);
        double diff = TedisAndSilvetosPoints - RadisAndAsensPoints;

        if (TedisAndSilvetosPoints > RadisAndAsensPoints) {
            System.out.println("GIRLS WIN");
            System.out.printf("Difference: %.0f", Math.floor(diff));
        } else if (TedisAndSilvetosPoints < RadisAndAsensPoints){
            diff = Math.abs(diff);
            System.out.println("BOYS WIN");
            System.out.printf("Difference: %.0f", Math.floor(diff));
        } else {
            System.out.printf("EQUAL: %.0f", Math.floor(RadisAndAsensPoints));
        }
    }
}
