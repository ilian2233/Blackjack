package org.example.Models.Impl;

import org.example.Enums.Rank;
import org.example.Models.Card;

import java.util.List;

public class HandValueCalculator {

    public static int calculateValOfHand(List<Card> hand) {
        int sum = hand.stream().mapToInt(Card::getVal).sum();
        int numOfAces = (int) hand.stream().filter(card -> card.getRank() == Rank.ace).count();
        for (int i = 0; i < numOfAces && sum > 21; i++) {
            sum -= 10;
        }
        return sum;
    }

}
