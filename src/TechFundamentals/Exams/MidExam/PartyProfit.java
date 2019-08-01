package TechFundamentals.Exams.MidExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartyProfit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int partySize = Integer.valueOf(reader.readLine());
        int days = Integer.valueOf(reader.readLine());
        int coins = 0;
        boolean motivationalParty = false;
        for (int i = 1; i <= days; i++) {
            if (i % 10 == 0) {
                partySize -= 2;
            }
            if (i % 15 == 0) {
                partySize += 5;
            }
            coins += 50;
            coins -= 2 * partySize;
            if (i % 3 == 0) {
                coins -= partySize * 3;
                motivationalParty = true;
            } else {
                motivationalParty = false;
            }

            if (i % 5 == 0) {
                coins += 20 * partySize;
                if (motivationalParty) {
                    coins -= 2 * partySize;
                }
            }
        }
        System.out.println(String.format(
                "%d companions received %d coins each.", partySize, coins / partySize));


    }
}
