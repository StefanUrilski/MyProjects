package JavaOOP.CommunicationAndEvents.KingGambit;

import JavaOOP.CommunicationAndEvents.KingGambit.models.King;
import JavaOOP.CommunicationAndEvents.KingGambit.models.KingsGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String kingName = reader.readLine();
        String[] royalGuards = reader.readLine().split("\\s+");
        String[] footman = reader.readLine().split("\\s+");

        KingsGuard guard = new KingsGuard();
        King king = new King(kingName, guard);

        guard.addFootman(footman);
        guard.addRoyalGuards(royalGuards);

        String input = reader.readLine();

        while (! input.equals("End")) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("Attack")) {
                king.underAttack();
            } else if (tokens[0].equals("Kill")) {
                guard.attackGuard(tokens[1]);
            }

            input = reader.readLine();
        }

    }
}
