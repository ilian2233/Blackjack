package org.example.Models.Impl;

import org.example.Models.Card;
import org.example.Models.Deck;
import org.example.Models.Impl.DeckImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

class DeckTest {

    @Test
    void createDeckTest() {
        Deck deck = new DeckImpl();

        int count = 0;
        for (Card i : deck.getCards()) {
            System.out.println(i);
            count++;
        }

        assert count == 52;
    }

    @Test
    void shuffleDeckTest() {
        Deck deck = new DeckImpl();

        List<Card> cards = deck.getCards();

        deck.shuffleDeck();

        boolean flag = false;
        int j = 0;
        for (Card i : deck.getCards()) {
            if (i.equals(cards.get(j++))) {
                flag = true;
            }
        }
        assert flag;
    }

    @Test
    void getCardTest(){
        Deck deck = new DeckImpl();

        Card c = deck.getCard();

        assert !deck.getCards().contains(c);
    }

}