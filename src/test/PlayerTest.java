package test;

import model.Player;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    public Player player1;
    public Player player2;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Player1", new Position(1, 1), 0);
        player2 = new Player("Player2", 0, 0, 0);
    }

    @Test
    public void testConstructor1() {
        assertEquals("Player1", player1.getName());
        assertEquals(new Position(1, 1), player1.getCar().getPos());
        assertEquals(0, player1.getScore());
        assertEquals(0, player1.getCar().getDirection());
    }

    @Test
    public void testConstructor2() {
        assertEquals("Player2", player2.getName());
        assertEquals(new Position(0, 0), player2.getCar().getPos());
        assertEquals(0, player2.getScore());
        assertEquals(0, player2.getCar().getDirection());
    }

    @Test
    public void testAddOneToScore() {
        assertEquals(0, player1.getScore());
        player1.addOneToScore();
        assertEquals(1, player1.getScore());
    }
}