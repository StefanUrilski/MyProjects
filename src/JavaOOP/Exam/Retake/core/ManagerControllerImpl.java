package JavaOOP.Exam.Retake.core;

import JavaOOP.Exam.Retake.common.ConstantMessages;
import JavaOOP.Exam.Retake.core.interfaces.ManagerController;
import JavaOOP.Exam.Retake.models.battleFields.BattleFieldImpl;
import JavaOOP.Exam.Retake.models.cards.MagicCard;
import JavaOOP.Exam.Retake.models.cards.TrapCard;
import JavaOOP.Exam.Retake.models.cards.interfaces.Card;
import JavaOOP.Exam.Retake.models.players.Advanced;
import JavaOOP.Exam.Retake.models.players.Beginner;
import JavaOOP.Exam.Retake.models.players.interfaces.Player;
import JavaOOP.Exam.Retake.repositories.CardRepositoryImpl;
import JavaOOP.Exam.Retake.repositories.PlayerRepositoryImpl;
import JavaOOP.Exam.Retake.repositories.interfaces.CardRepository;
import JavaOOP.Exam.Retake.repositories.interfaces.PlayerRepository;


public class ManagerControllerImpl implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private BattleFieldImpl battleField;

    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.battleField = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        CardRepository cardRepository = new CardRepositoryImpl();

        if (type.equals("Beginner")) {
            player = new Beginner(cardRepository, username);
        } else {
            player = new Advanced(cardRepository, username);
        }
        playerRepository.add(player);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;

        if (type.equals("Magic")) {
            card = new MagicCard(name);
        } else {
            card = new TrapCard(name);
        }

        cardRepository.add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Card card = cardRepository.find(cardName);
        playerRepository.find(username).getCardRepository().add(card);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        BattleFieldImpl battleField = new BattleFieldImpl();
        Player firstPlayer = playerRepository.find(attackUser);
        Player secondPlayer = playerRepository.find(enemyUser);

        battleField.fight(firstPlayer, secondPlayer);

        return String.format(ConstantMessages.FIGHT_INFO, firstPlayer.getHealth(), secondPlayer.getHealth());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        playerRepository.getPlayers().forEach(player -> {
            sb.append(player.toString()).append("\n");
            sb.append(ConstantMessages.DEFAULT_REPORT_SEPARATOR).append("\n");
        });

        return sb.toString();
    }
}
