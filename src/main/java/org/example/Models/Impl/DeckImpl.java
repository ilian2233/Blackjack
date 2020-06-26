package org.example.Models.Impl;

import org.example.Enums.Rank;
import org.example.Enums.Suite;
import org.example.Models.Card;
import org.example.Models.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckImpl implements Deck {

    private final List<Card> cards = new ArrayList<>();

    public DeckImpl() {
        for (Suite i : Suite.values()) {
            for (Rank j : Rank.values()) {
                cards.add(new CardImpl(i, j));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public Card getCard() {
        Card card = cards.get(0);
        cards.remove(card);
        return card;
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
