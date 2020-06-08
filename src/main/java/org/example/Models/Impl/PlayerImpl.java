package org.example.Models.Impl;


import org.example.Models.Card;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl extends AbstractPlayer {

    private double bank;
    private List<Card> hand = new ArrayList<>();

    public PlayerImpl(double bank) {
        super(bank);
    }
}
