package org.example.Models.Impl;

public class Dealer extends AbstractPlayer {

    public Dealer() {
        super(Double.MAX_VALUE);
    }

    @Override
    public boolean bet(double amount) {

        if (!super.bet(amount)) {
            addToBank(Double.MAX_VALUE - super.getBankAmount());
        }

        return super.bet(amount);
    }
}
