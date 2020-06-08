package org.example.Models;

import java.util.List;

public interface Deck {

    List<Card> getCards();

    Card getCard();

    void shuffleDeck();
}
