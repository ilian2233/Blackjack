package org.example.Models.Impl;

import org.example.Models.BlackjackBot;
import org.example.Models.Deck;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BlackjackBotTest {

    @Test
    public void playTest() {
        Deck deck;

        for (int i = 0; i < 50; i++) {
            deck = new DeckImpl();
            deck.shuffleDeck();
            System.out.println(BlackjackBot.getBestMove(Arrays.asList(deck.getCard(), deck.getCard())));
        }
    }

}