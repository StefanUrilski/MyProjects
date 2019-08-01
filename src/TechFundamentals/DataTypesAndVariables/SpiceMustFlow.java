package TechModule.DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiceMustFlow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long yield = Integer.valueOf(reader.readLine());
        int days = 0;
        int spiceAmount = 0;
        while (true) {
            spiceAmount += yield - 26;
            days ++;
            yield -= 10;
            if (yield < 100) {
                spiceAmount -= 26;
                System.out.println(days);
                System.out.println(spiceAmount);
                return;
            }
        }

    }
}
