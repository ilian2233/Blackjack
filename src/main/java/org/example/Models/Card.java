package org.example.Models;

import org.example.Enums.Rank;

public interface Card {

    String toString();

    boolean equals(Object o);

    Rank getRank();

    int getVal();
}
