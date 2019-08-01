package JavaOOP.Exam.Retake.models.battleFields;

import JavaOOP.Exam.Retake.models.battleFields.interfaces.Battlefield;
import JavaOOP.Exam.Retake.models.cards.interfaces.Card;
import JavaOOP.Exam.Retake.models.players.Beginner;
import JavaOOP.Exam.Retake.models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }

        if (attackPlayer instanceof Beginner) {
            beginnerUpdatingStatus(attackPlayer);
        }

        if (enemyPlayer instanceof Beginner) {
            beginnerUpdatingStatus(enemyPlayer);
        }

        attackPlayer.setHealth(attackPlayer.getHealth() + getBonusCardHealth(attackPlayer));
        enemyPlayer.setHealth(enemyPlayer.getHealth() + getBonusCardHealth(enemyPlayer));

        while (true) {
            int attackerDamage = attackPlayer.getCardRepository().getCards().iterator().next().getDamagePoints();
            int enemyDamage = enemyPlayer.getCardRepository().getCards().iterator().next().getDamagePoints();

            enemyPlayer.takeDamage(attackerDamage);
            if (enemyPlayer.isDead()) {
                break;
            }

            attackPlayer.takeDamage(enemyDamage);
            if (attackPlayer.isDead()) {
                break;
            }
        }
    }

    private void beginnerUpdatingStatus(Player player) {
        player.setHealth(player.getHealth() + 40);

        player.getCardRepository().getCards()
                .forEach(card -> card.setDamagePoints(card.getDamagePoints() + 30));
    }

    private int getBonusCardHealth(Player player) {
        int totalHealth = 0;

        for (Card card : player.getCardRepository().getCards()) {
            totalHealth += card.getHealthPoints();
        }

        return totalHealth;
    }
}
