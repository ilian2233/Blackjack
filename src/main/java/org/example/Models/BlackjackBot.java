package org.example.Models;

import org.example.Enums.Move;
import org.example.Enums.Rank;
import org.example.Models.Impl.DeckImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface BlackjackBot {

    private static int calculateValOfHand(List<Card> hand) {
        //TODO: duplicate method make static or split in calculator
        int sum = hand.stream().mapToInt(Card::getVal).sum();
        int numOfAces = (int) hand.stream().filter(card -> card.getRank() == Rank.ace).count();
        for (int i = 0; i < numOfAces && sum > 21; i++) {
            sum -= 10;
        }
        return sum;
    }

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
            int isEqualTo21 = Integer.compare(calculateValOfHand(a), 21);
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
