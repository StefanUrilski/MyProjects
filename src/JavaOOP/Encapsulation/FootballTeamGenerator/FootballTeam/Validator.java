package JavaOOP.Encapsulation.FootballTeamGenerator.FootballTeam;

public class Validator {
    public static boolean wrongName(String name) {
        return name == null || name.trim().isEmpty();
    }

    public static boolean wrongStats(int stats) {
        return stats < 0 || stats > 100;
    }
}
