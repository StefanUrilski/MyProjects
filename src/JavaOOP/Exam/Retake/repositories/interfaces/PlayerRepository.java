package JavaOOP.Exam.Retake.repositories.interfaces;

import JavaOOP.Exam.Retake.models.players.interfaces.Player;

import java.util.List;

public interface PlayerRepository {
    int getCount();

    List<Player> getPlayers();

    void add(Player player);

    boolean remove(Player player);

    Player find(String name);
}
