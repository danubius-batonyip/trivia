package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

public class GameOutputImplTest {

    @Test
    void printlnTest() {
        Output output = new GameOutputImpl();
        output.println("");
        output.println(null);
        output.println("TESZT");
    }
}
