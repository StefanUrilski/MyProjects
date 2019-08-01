package JavaOOP.Exam.Retake.models.players;

import JavaOOP.Exam.Retake.common.ConstantMessages;
import JavaOOP.Exam.Retake.models.players.interfaces.Player;
import JavaOOP.Exam.Retake.repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private CardRepository cardRepository;
    private String name;
    private int health;

    protected BasePlayer(CardRepository cardRepository, String name, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(name);
        this.setHealth(health);
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    private void setUsername(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }

        this.name = name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }

        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return health == 0;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }

        this.health -= damagePoints;

        if (health < 0) {
            health = 0;
        }
    }

    @Override
    public String toString() {
        return String.format(ConstantMessages.PLAYER_REPORT_INFO + "%s",
                this.name,
                this.health,
                this.cardRepository.getCount(),
                this.cardRepository.getCount() > 0 ? "\n" + cardRepository.toString() : ""
        );
    }
}
