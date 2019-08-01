package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            switch (input[0]) {
                case "Delete":
                    int numberForDelete = Integer.valueOf(input[1]);
                    numbers.removeIf(n -> n.equals(numberForDelete));
                    break;
                case "Insert":
                    int element = Integer.valueOf(input[1]);
                    int index = Integer.valueOf(input[2]);
                    if (numbers.size() > index && index >= 0) {
                        numbers.add(index, element);
                    }
                    break;
                case "end":
                    for (Integer number : numbers) {
                        System.out.print(number + " ");
                    }
                    return;
                default:
                    System.out.println("Wrong input. Try again.");
                    break;
            }
        }

    }
}
