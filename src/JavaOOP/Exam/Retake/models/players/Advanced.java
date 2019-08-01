package JavaOOP.Exam.Retake.models.players;

import JavaOOP.Exam.Retake.repositories.interfaces.CardRepository;

public class Advanced extends BasePlayer {
    private static final int DEFAULT_HEALTH_POINTS = 250;

    public Advanced(CardRepository cardRepository, String name) {
        super(cardRepository, name, DEFAULT_HEALTH_POINTS);
    }
}
