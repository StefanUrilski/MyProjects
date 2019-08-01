package JavaOOP.Exam.Retake.repositories;

import JavaOOP.Exam.Retake.models.cards.interfaces.Card;
import JavaOOP.Exam.Retake.repositories.interfaces.CardRepository;

import java.util.*;

public class CardRepositoryImpl implements CardRepository {
    private Map<String, Card> cards;

    public CardRepositoryImpl() {
        this.cards = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards.values());
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }

        if (cards.containsKey(card.getName())) {
            throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
        }

        this.cards.put(card.getName(), card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        return this.cards.remove(card.getName(), card);
    }

    @Override
    public Card find(String name) {
        return this.cards.get(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.cards.values().forEach(card -> sb.append(card.toString()).append("\n"));

        return sb.toString();
    }
}

