package TechFundamentals.StringsAndTextProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bigNumber = reader.readLine();
        int multiplier = Integer.valueOf(reader.readLine());
        if (multiplier == 0) {
            System.out.println(0);
            return;
        }
        int temp = 0;
        int tempSecondDigit;
        StringBuilder reverseResult = new StringBuilder();
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int currNumber = bigNumber.charAt(i) - '0';
            int multiply = currNumber * multiplier;
            int firstDigit = multiply % 10;
            int secondDigit = multiply / 10;
            temp += firstDigit;
            if (temp > 9) {
                tempSecondDigit = temp / 10;
                temp = temp % 10;
            } else {
                tempSecondDigit = 0;
            }
            reverseResult.append(temp);
            temp = secondDigit + tempSecondDigit;
        }
        if (temp != 0) {
            reverseResult.append(temp);
        }
        String result = reverseResult.toString();
        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
    }
}
