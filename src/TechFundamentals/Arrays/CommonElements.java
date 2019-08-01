package TechFundamentals.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstInput = reader.readLine();
        String[] firstArr = firstInput.split(" ");
        String secondInput = reader.readLine();
        String[] secondArr = secondInput.split(" ");

        for (String aSecondArr : secondArr) {
            for (String aFirstArr : firstArr) {
                if (aSecondArr.equals(aFirstArr)) {
                    System.out.print(aSecondArr + " ");
                }
            }
        }

    }
}
