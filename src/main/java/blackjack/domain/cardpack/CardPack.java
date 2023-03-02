package blackjack.domain.cardpack;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.CardShape;
import java.util.ArrayList;
import java.util.List;

public class CardPack {

    private final List<Card> cards;

    public CardPack() {
        cards = new ArrayList<>();
        initCardsShape();
    }

    private void initCardsShape() {
        for (final CardShape currentShape : CardShape.values()) {
            matchingNumberByShape(currentShape);
        }
    }

    private void matchingNumberByShape(final CardShape currentShape) {
        for (final CardNumber currentNumber : CardNumber.values()) {
            cards.add(new Card(currentNumber, currentShape));
        }
    }

    public void shuffle(final ShuffleStrategy strategy) {
        strategy.shuffle(cards);
    }

    public int size() {
        return cards.size();
    }

    public Card pop() {
        return cards.remove(cards.size() - 1);
    }
}
