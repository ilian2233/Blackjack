package org.example.Models;

import java.util.List;
import java.util.Optional;

public interface Game {

    void hitPlayer();

    void hitDealer();

    Optional<Player> getWinner();

    List<Card> getPlayersHand();

    List<Card> getDealersHand();

    int getPlayerHandValue();

    int getDealerHandValue();

    double getBetAmount();

    void dealerPlay();

    void addWinningsOrLosesToPlayer();
}
