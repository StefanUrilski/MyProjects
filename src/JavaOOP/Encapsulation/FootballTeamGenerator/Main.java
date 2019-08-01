package JavaOOP.Encapsulation.FootballTeamGenerator;

import JavaOOP.Encapsulation.FootballTeamGenerator.FootballTeam.Player;
import JavaOOP.Encapsulation.FootballTeamGenerator.FootballTeam.Team;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Map<String, Team> teamMap = new HashMap<>();
        Team team = null;
        Player player = null;

        while (!input.equalsIgnoreCase("end")) {

            String[] tokens = input.split(";");
            try {
                if (tokens[0].equalsIgnoreCase("team")) {
                    team = new Team(tokens[1]);
                    teamMap.putIfAbsent(tokens[1], team);
                } else if (tokens[0].equalsIgnoreCase("add")) {
                    if (teamMap.containsKey(tokens[1])) {
                        player = new Player(tokens[2],
                                Integer.parseInt(tokens[3]),
                                Integer.parseInt(tokens[4]),
                                Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]),
                                Integer.parseInt(tokens[7]));

                        teamMap.get(tokens[1]).addPlayer(player);
                    } else {
                        throw new IllegalArgumentException("Team " + tokens[1] + " does not exist.");
                    }

                } else if (tokens[0].equalsIgnoreCase("Remove")) {
                    if (teamMap.containsKey(tokens[1])) {
                        teamMap.get(tokens[1]).removePlayer(tokens[2]);
                    } else {
                        throw new IllegalArgumentException("Team " + tokens[1] + " does not exist.");
                    }

                } else if (tokens[0].equals("Rating")) {
                    if (teamMap.containsKey(tokens[1])) {
                        //int result = (int) teamMap.get(tokens[1]).getRating();
                        System.out.println(String.format("%s - %.0f", tokens[1], teamMap.get(tokens[1]).getRating()));
                    } else {
                        throw new IllegalArgumentException("Team " + tokens[1] + " does not exist.");
                    }
                }
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            input = reader.readLine();
        }


    }
}