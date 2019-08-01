package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BombNumberNew {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] bombAndPower = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (bombAndPower[1] < 0) {
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombAndPower[0]) {
                int power = bombAndPower[1];
                // delete left side of the bomb
                for (int j = 0; j < power; j++) {
                    if (i == 0) {
                        break;
                    }
                    numbers.remove(i - 1);
                    i--;
                }
                // delete right side of the bomb
                for (int j = 0; j < power; j++) {
                    if (i == numbers.size() - 1){
                        break;
                    }
                    numbers.remove(i + 1);
                }
                numbers.remove(i);
                i--;
            }
        }
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        System.out.println(result);

    }
}
