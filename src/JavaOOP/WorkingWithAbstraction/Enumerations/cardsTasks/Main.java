package JavaOOP.WorkingWithAbstraction.Enumerations.cardsTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String power = reader.readLine();
        String suit = reader.readLine();

        Cards card = new Cards(CardSuit.valueOf(suit), CardRang.valueOf(power));

        System.out.println(String.format("Card name: %s of %S; Card power: %d",
                CardRang.valueOf(power), CardSuit.valueOf(suit), card.calcutate()));

    }
}
