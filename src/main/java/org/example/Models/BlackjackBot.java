package org.example.Models;

import org.example.Enums.Move;
import org.example.Models.Impl.DeckImpl;
import org.example.Models.Impl.HandValueCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface BlackjackBot {

    @SafeVarargs
    static Move getBestMove(List<Card> ownHand, List<Card>... hands) {
        Deck deck = new DeckImpl();
        deck.getCards().removeAll(ownHand);
        try {
            deck.getCards().removeAll(Arrays.asList(hands));
        } catch (NullPointerException ignored) {
        }

        AtomicInteger result = new AtomicInteger(0);

        deck.getCards().forEach(i -> {
            List<Card> a = new ArrayList<>(ownHand);
            a.add(i);
            int isEqualTo21 = Integer.compare(HandValueCalculator.calculateValOfHand(a), 21);
            if (isEqualTo21 <= 0) {
                result.addAndGet(1);
            } else {
                result.addAndGet(-1);
            }
        });

        if (result.get() >= 0) {
            return Move.Hit;
        } else {
            return Move.Stand;
        }

    }
}
