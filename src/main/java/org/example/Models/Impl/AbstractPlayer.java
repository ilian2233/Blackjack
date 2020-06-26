package org.example.Models.Impl;

import org.example.Models.Card;
import org.example.Models.Player;

import java.util.ArrayList;
import java.util.List;

public class AbstractPlayer implements Player {

    private double bank;
    private final List<Card> hand = new ArrayList<>();

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

    @Override
    public int getValOfHand() {
        return HandValueCalculator.calculateValOfHand(hand);
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
