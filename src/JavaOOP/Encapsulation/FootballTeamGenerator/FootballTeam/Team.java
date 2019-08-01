package JavaOOP.Encapsulation.FootballTeamGenerator.FootballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (Validator.wrongName(name)) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean containsName = this.players.stream().anyMatch(player -> player.getName().equals(name));

        if (! containsName) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }

        this.players.removeIf(player -> player.getName().equals(name));
    }

    public double getRating() {
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }

    public boolean isEmpty() {
        return this.players.isEmpty();
    }
}
