package TechFundamentals.Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> firstPlayer = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayer = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int count = 0;
        boolean isTrue = true;
        while(isTrue) {
            if (firstPlayer.size() == 0 || secondPlayer.size() == 0){
                isTrue = false;
                break;
            }
            if(firstPlayer.get(0) > secondPlayer.get(0)) {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.add(secondPlayer.get(0));
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else if(firstPlayer.get(0) < secondPlayer.get(0)) {
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.add(firstPlayer.get(0));
                secondPlayer.remove(0);
                firstPlayer.remove(0);
            } else if(firstPlayer.get(0).equals(secondPlayer.get(0))) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
            count++;
        }
        int sum = 0;
        if (firstPlayer.size() != 0) {
            for (Integer card : firstPlayer) {
                sum += card;
            }
            System.out.println("First player wins! Sum: " + sum);
        } else if (secondPlayer.size() != 0) {
            for (Integer card : secondPlayer) {
                sum += card;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
