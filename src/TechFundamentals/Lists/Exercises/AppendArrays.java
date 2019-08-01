package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AppendArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\|");

        List<Integer> numbers = new ArrayList<>();
        for (int i = tokens.length - 1; i >= 0; i--) {
            String curr = tokens[i];
            String[] temp = curr.split("\\s+");
            for (String i1 : temp) {
                if (!i1.equals("")) {
                    numbers.add(Integer.parseInt(i1));
                }
            }
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
