package org.example.Models;

import java.util.List;

public interface Player {

    boolean bet(double amount);

    void addToBank(double amount);

    double getBankAmount();

    void addCardToHand(Card card);

    int getValOfHand();

    List<Card> getHand();

    void clearHand();
}
