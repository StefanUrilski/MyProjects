package TechFundamentals.StringsAndTextProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int startIndex = input.indexOf(">") + 1;
        int power = 0;
        for (int i = startIndex; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                power += input.charAt(i) - '0';
            }
            if (input.charAt(i) != '>') {
                if (power > 0) {
                    StringBuilder temp = new StringBuilder();
                    temp.append(input);
                    temp.deleteCharAt(i);
                    input = temp.toString();
                    power--;
                    i--;
                }
            }
        }
        System.out.println(input);

    }
}
