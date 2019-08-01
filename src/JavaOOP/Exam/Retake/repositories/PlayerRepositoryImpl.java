package JavaOOP.Exam.Retake.repositories;

import JavaOOP.Exam.Retake.models.players.interfaces.Player;
import JavaOOP.Exam.Retake.repositories.interfaces.PlayerRepository;

import java.util.*;

public class PlayerRepositoryImpl implements PlayerRepository {
    private Map<String, Player> players;

    public PlayerRepositoryImpl() {
        this.players = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>(players.values());
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        if (players.containsKey(player.getUsername())) {
            throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
        }

        this.players.put(player.getUsername(), player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        return this.players.remove(player.getUsername(), player);
    }

    @Override
    public Player find(String name) {
        return this.players.get(name);
    }
}
