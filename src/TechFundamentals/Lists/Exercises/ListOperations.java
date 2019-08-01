package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        boolean isTrue = true;
        while (isTrue) {
            String input = reader.readLine();
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Add" :
                    numbers.add(Integer.valueOf(command[1]));
                    break;
                case "Insert":
                    int element = Integer.parseInt(command[1]);
                    int index = Integer.parseInt(command[2]);
                    if (numbers.size() > index && index >= 0) {
                        numbers.add(index, element);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int remove = Integer.valueOf(command[1]);
                    if (numbers.size() > remove && remove >= 0) {
                        numbers.remove(remove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    if (command[1].equals("left")) {
                        shiftLeft(numbers, count);
                    } else if (command[1].equals("right")){
                        shiftRight(numbers, count);
                    }
                    break;
                case "End":
                    for (Integer number : numbers) {
                        System.out.print(number + " ");
                    }
                    isTrue = false;
                    break;
                    default:
                        System.out.println("Wrong action! Try again.");
                        break;
            }
        }

    }

    private static void shiftLeft(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            numbers.add(numbers.get(0));
            numbers.remove(0);
        }

    }
    private static void shiftRight(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int temp = numbers.get(numbers.size() - 1);
            numbers.add(0, temp);
            numbers.remove(numbers.size() - 1);
        }
    }
}
