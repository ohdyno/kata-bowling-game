package me.ohdyno.xing.BowlingGame.test;

import me.ohdyno.xing.BowlingGame.main.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTests {
    private Game g;

    @Test
    public void testGutterGame() {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare() throws Exception {
        rollSpare();
        g.roll(5);
        rollMany(17, 0);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(2);
        rollMany(17, 0);
        assertEquals(20, g.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }

    private void rollStrike() {
        g.roll(10);
    }

    @Before
    public void setUp() {
        g = new Game();
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++)
            g.roll(pins);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
}
