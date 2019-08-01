package OtherCourses.MapsLambdaAndStreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> handOfCards = new LinkedHashMap<>();
        Map<String, Integer> sumOfTheCards = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String player = tokens[0];
            String[] cards = tokens[1].split(", ");
            handOfCards.putIfAbsent(player, new ArrayList<>());
            sumOfTheCards.putIfAbsent(player, 0);
            for (String card : cards) {
                if (!handOfCards.get(player).contains(card)) {
                    handOfCards.get(player).add(card);
                    String[] cardValue = card.split("");
                    char powerAsChar = cardValue[0].charAt(0);
                    char typeAsChar = cardValue[1].charAt(0);
                    int power;
                    int type = 0;
                    switch (powerAsChar) {
                        case 'J':
                            power = 11;
                            break;
                        case 'Q':
                            power = 12;
                            break;
                        case 'K':
                            power = 13;
                            break;
                        case 'A':
                            power = 14;
                            break;
                        default:
                            power = powerAsChar - '0';
                            break;
                    }
                    if (cardValue.length > 2) {
                        power = 10;
                        typeAsChar = cardValue[2].charAt(0);
                    }
                    switch (typeAsChar) {
                        case 'C':
                            type = 1;
                            break;
                        case 'D':
                            type = 2;
                            break;
                        case 'H':
                            type = 3;
                            break;
                        case 'S':
                            type = 4;
                            break;
                    }
                    int sum = power * type;
                    sumOfTheCards.put(player, sumOfTheCards.get(player) + sum);
                }
            }
            input = reader.readLine();
        }
        for (Map.Entry<String, Integer> entry : sumOfTheCards.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

