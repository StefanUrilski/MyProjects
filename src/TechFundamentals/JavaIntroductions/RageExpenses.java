package TechModule.JavaIntroductions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RageExpenses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lostGames = Integer.valueOf(reader.readLine());
        double headsetPrice = Double.valueOf(reader.readLine());
        double mousePrice = Double.valueOf(reader.readLine());
        double keyboardPrice = Double.valueOf(reader.readLine());
        double displayPrice = Double.valueOf(reader.readLine());

        int headsetTrashed = lostGames / 2;
        int mouseTrashed = lostGames / 3;
        int keyboardTrashed = lostGames / 6;
        int displayTrashed = lostGames / 12;

        double totalExpenses = headsetPrice * headsetTrashed + mousePrice * mouseTrashed +
                keyboardPrice * keyboardTrashed + displayPrice * displayTrashed;
        System.out.println(String.format("Rage expenses: %.2f lv.", totalExpenses));
    }
}
