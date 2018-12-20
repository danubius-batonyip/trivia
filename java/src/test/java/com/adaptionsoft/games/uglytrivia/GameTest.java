package com.adaptionsoft.games.uglytrivia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Output testOutput;

    private Game game;

    @Before
    public void init() {
        this.testOutput = new TestOutput();
        this.game = new Game(this.testOutput);
    }

    @After
    public void after() {
        System.out.println("Test out:");
        System.out.println(this.testOutput);
    }

    @Test
    public void createRockQuestionTest() {
        String question = game.createRockQuestion(-1);
        assertNotNull(question);
        assertNotSame("",question);
        assertEquals("Rock Question -1",question);
    }

    @Test
    public void isPlayableTest() {
        assertFalse(game.isPlayable());

        assertTrue(game.add("Első"));
        assertFalse(game.isPlayable());

        assertTrue(game.add("Második"));
        assertTrue(game.isPlayable());
    }

    @Test
    public void howManyPlayersTest() {
        int initSize = game.howManyPlayers();
        assertEquals(0,initSize);

        game.add(null);

        assertEquals(initSize + 1, game.howManyPlayers());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void rollTestWithoutPlayers() {
        game.roll(-1);
    }

    @Test
    public void rollTestWithOnePlayer() {
        game.add("Julika");

        game.roll(-1);
    }
}
