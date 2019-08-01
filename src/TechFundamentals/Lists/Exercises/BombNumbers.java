package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] bombAndPower = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (bombAndPower[0] < 0 || bombAndPower[1] < 0) {
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            // delete left side of the bomb
            if (numbers.get(i) == bombAndPower[0]) {
                if ((i - 1) - bombAndPower[1] >= 0) {
                    for (int j = 0; j < bombAndPower[1]; j++) {
                        numbers.remove(i - 1);
                        i--;
                    }
                } else {
                    for (int k = 0; k <= i - 1; k++) {
                        numbers.remove(i - 1);
                        i--;
                    }
                }
                // delete right side of the bomb
                if ((i + 1) + bombAndPower[1] < numbers.size()) {
                    for (int l = 0; l < bombAndPower[1]; l++) {
                        numbers.remove(i + 1);
                    }
                } else {
                    int length = numbers.size() - (i + 1);
                    for (int m = 0; m < length; m++) {
                        numbers.remove(i + 1);
                    }
                }
                numbers.remove(i);
            }
        }
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        System.out.println(result);
    }
}
