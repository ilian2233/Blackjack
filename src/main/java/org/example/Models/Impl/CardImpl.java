package org.example.Models.Impl;

import org.example.Enums.Rank;
import org.example.Enums.Suite;
import org.example.Models.Card;

import java.util.List;

public class CardImpl implements Card {

    Suite suite;
    Rank rank;

    public CardImpl(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardImpl card = (CardImpl) o;
        return getSuite() == card.getSuite() &&
                getRank() == card.getRank();
    }

    @Override
    public int getVal() {
        return getRank().value;
    }
}
