package JavaOOP.Exam.Retake.models.players.interfaces;

import JavaOOP.Exam.Retake.repositories.interfaces.CardRepository;

public interface Player {
    CardRepository getCardRepository();

    String getUsername();

    int getHealth();

    void setHealth(int healthPoints);

    boolean isDead();

    void takeDamage(int damagePoints);
}
