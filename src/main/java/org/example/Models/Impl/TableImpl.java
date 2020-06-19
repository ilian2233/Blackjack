package org.example.Models.Impl;

import org.example.Models.Deck;
import org.example.Models.Game;
import org.example.Models.Player;
import org.example.Models.Table;

public class TableImpl implements Table {

    Player player;
    Dealer dealer = new Dealer();
    Deck deck = new DeckImpl();

    public TableImpl(double playerCash) {
        this.player = new PlayerImpl(playerCash);
    }

    public TableImpl setDealer(Dealer dealer) {
        this.dealer = dealer;
        return this;
    }

    public TableImpl setDeck(Deck deck) {
        this.deck = deck;
        return this;
    }

    private void giveStarterCarts() {
        dealer.addCardToHand(deck.getCard());
        player.addCardToHand(deck.getCard());
        player.addCardToHand(deck.getCard());
    }

    private void removePreviousCards() {
        deck.getCards().addAll(dealer.getHand());
        deck.getCards().addAll(player.getHand());
        player.clearHand();
        dealer.clearHand();
    }

    public Game startRound(double bet) {
        deck.shuffleDeck();

        removePreviousCards();

        giveStarterCarts();

        player.bet(bet);
        dealer.bet(bet);

        return new GameImpl(this, bet);
    }

    @Override
    public int getPlayerBankAmount() {
        return (int) player.getBankAmount();
    }
}
