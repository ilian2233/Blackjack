package org.example.Models.Impl;


import org.example.Enums.Rank;
import org.example.Enums.Suite;
import org.example.Models.Card;
import org.example.Models.Player;

import java.util.ArrayList;
import java.util.List;

public class AbstractPlayer implements Player {

    private double bank;
    private List<Card> hand = new ArrayList<>();

    public AbstractPlayer(double bank) {
        this.bank = bank;
    }

    @Override
    public boolean bet(double amount) {
        if (amount <= bank) {
            bank -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void addToBank(double amount) {
        bank += amount;
    }

    @Override
    public double getBankAmount() {
        return bank;
    }

    @Override
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    private boolean handContainsAce() {
        return hand.contains(new CardImpl(Suite.clubs, Rank.ace)) ||
                hand.contains(new CardImpl(Suite.diamonds, Rank.ace)) ||
                hand.contains(new CardImpl(Suite.hearts, Rank.ace)) ||
                hand.contains(new CardImpl(Suite.spades, Rank.ace));
    }

    private int calculateValOfHand() {
        int sum = hand.stream().mapToInt(Card::getVal).sum();
        int numOfAces = (int) hand.stream().filter(card -> card.getRank() == Rank.ace).count();
        for (int i = 0; i < numOfAces && sum > 21; i++) {
            sum -= 10;
        }
        return sum;
    }

    @Override
    public int getValOfHand() {
        return calculateValOfHand();
    }

    @Override
    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    @Override
    public void clearHand() {
        hand.clear();
    }
}
