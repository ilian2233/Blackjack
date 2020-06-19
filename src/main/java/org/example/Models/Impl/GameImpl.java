package org.example.Models.Impl;

import org.example.Enums.Move;
import org.example.Models.BlackjackBot;
import org.example.Models.Card;
import org.example.Models.Game;
import org.example.Models.Player;

import java.util.List;
import java.util.Optional;

class GameImpl implements Game {

    TableImpl table;
    Double bet;

    GameImpl(TableImpl table, Double bet) {
        this.table = table;
        this.bet = bet;
    }

    public void hitPlayer() {
        table.player.addCardToHand(table.deck.getCard());
    }

    public void hitDealer() {
        table.dealer.addCardToHand(table.deck.getCard());
    }

    public Optional<Player> getWinner() {

        if (table.player.getValOfHand() > 21) {
            if (table.dealer.getValOfHand() > 21) {
                return Optional.empty();
            }
            return Optional.of(table.dealer);
        } else if (table.dealer.getValOfHand() > 21) {
            return Optional.of(table.player);
        }

        if (table.player.getValOfHand() == table.dealer.getValOfHand()) {
            return Optional.empty();
        } else if (table.player.getValOfHand() > table.dealer.getValOfHand()) {
            return Optional.of(table.player);
        } else {
            return Optional.of(table.dealer);
        }
    }

    @Override
    public List<Card> getPlayersHand() {
        return table.player.getHand();
    }

    @Override
    public List<Card> getDealersHand() {
        return table.dealer.getHand();
    }

    @Override
    public int getPlayerHandValue() {
        return table.player.getValOfHand();
    }

    @Override
    public int getDealerHandValue() {
        return table.dealer.getValOfHand();
    }

    @Override
    public double getBetAmount() {
        return bet;
    }

    @Override
    public void dealerPlay() {
        while ( BlackjackBot.getBestMove(getDealersHand(), getPlayersHand()) == Move.Hit){
            hitDealer();
        }
    }

    @Override
    public void addWinningsOrLosesToPlayer() {

        try {
            if (getWinner().orElseThrow(NullPointerException::new).equals(table.player)) {
                table.player.addToBank(bet * 2);
            }
        } catch (NullPointerException ignored) {
        }
    }
}

