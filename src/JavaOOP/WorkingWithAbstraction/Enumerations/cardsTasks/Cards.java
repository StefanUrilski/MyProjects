package JavaOOP.WorkingWithAbstraction.Enumerations.cardsTasks;

public class Cards {
    private CardSuit suit;
    private CardRang rang;

    public Cards(CardSuit suit, CardRang rang) {
        this.suit = suit;
        this.rang = rang;
    }

    public int calcutate() {
        return this.suit.getValue() + this.rang.getPower();
    }
}
