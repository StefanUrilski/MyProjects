package StringsAndTextProcessing.MoreExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsciiSumator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char start = reader.readLine().charAt(0);
        char end = reader.readLine().charAt(0);
        String input = reader.readLine();

        int sum = 0;
        String some = "";
        for (char i = start; i < end; i++) {
            some += i;
        }
        for (int i = 0; i < some.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (some.charAt(i) == input.charAt(j)) {
                    sum += some.charAt(i);
                }
            }
        }
        System.out.println(sum);

    }
}
