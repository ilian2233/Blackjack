package org.example.Models.Impl;

import org.example.Models.Game;
import org.example.Models.Impl.TableImpl;
import org.example.Models.Table;
import org.junit.jupiter.api.Test;

public class TableAndGameTest {

    @Test
    void gameGenerationTest(){
        Table table = new TableImpl(1000);

        Game game = table.startRound(10);

        assert game!=null;
    }

}
