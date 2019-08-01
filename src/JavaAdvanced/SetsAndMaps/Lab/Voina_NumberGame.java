package OtherCourses.SetsAndMaps.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Voina_NumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();

        fillingTheSets(reader, firstPlayerCards, secondPlayerCards);

        int rounds = 50;
        while (rounds-- > 0) {
            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
            int currFirst = firstPlayerCards.iterator().next();
            int currSecond = secondPlayerCards.iterator().next();
            firstPlayerCards.remove(currFirst);
            secondPlayerCards.remove(currSecond);
            if (currFirst > currSecond) {
                firstPlayerCards.add(currFirst);
                firstPlayerCards.add(currSecond);
            } else if (currFirst < currSecond) {
                secondPlayerCards.add(currFirst);
                secondPlayerCards.add(currSecond);
            }
        }
        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerCards.size() < secondPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static void fillingTheSets(BufferedReader reader, Set<Integer> firstPlayerCards, Set<Integer> secondPlayerCards) throws IOException {
        String[] numbersOfFirst = reader.readLine().split("\\s+");
        String[] numbersOfSecond = reader.readLine().split("\\s+");

        for (String numb : numbersOfFirst) {
            firstPlayerCards.add(Integer.parseInt(numb));
        }
        for (String numb : numbersOfSecond) {
            secondPlayerCards.add(Integer.parseInt(numb));
        }
    }
}
