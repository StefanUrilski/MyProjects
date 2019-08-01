package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        List<Integer> wagons = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.valueOf(reader.readLine());

        while (true) {
            input = reader.readLine();
            String[] actions = input.split(" ");
            switch (actions[0]) {
                case "Add":
                    int addWagon = Integer.parseInt(actions[1]);
                    wagons.add(addWagon);
                    break;
                case "end":
                    for (Integer passengers : wagons) {
                        System.out.print(passengers + " ");
                    }
                    return;
                default:
                    int passengers = Integer.parseInt(actions[0]);
                    for (int i = 0; i < wagons.size(); i++) {
                        if (wagons.get(i) + passengers <= maxCapacity) {
                            int temp = wagons.get(i) + passengers;
                            wagons.set(i, temp);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
