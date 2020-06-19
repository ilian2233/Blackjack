package org.example.Models.Impl;

import org.example.Enums.Rank;
import org.example.Enums.Suite;
import org.example.Models.Impl.CardImpl;
import org.example.Models.Impl.PlayerImpl;
import org.example.Models.Player;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player = new PlayerImpl(1000);

    @Test
    void betTest() {
        assert player.bet(200) && !player.bet(2000);
    }

    @Test
    void addToBankTest() {
        player = new PlayerImpl(1000);
        player.addToBank(250);
        assert player.getBankAmount() == 1250;
    }

    @Test
    void addCardToHandTest() {
        player.addCardToHand(new CardImpl(Suite.clubs, Rank.ace));
        assert player.getValOfHand() == 11;
    }

    @Test
    void getValOfHandWhenValIsGreaterThen21Test() {
        player.addCardToHand(new CardImpl(Suite.clubs, Rank.ace));
        player.addCardToHand(new CardImpl(Suite.clubs, Rank.king));
        player.addCardToHand(new CardImpl(Suite.clubs, Rank.jack));
        assert player.getValOfHand() == 21;
    }

}