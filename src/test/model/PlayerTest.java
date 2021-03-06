package test.model;

import main.model.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

//This class is the test class for Player
public class PlayerTest {

    public Player player1;
    public Player player2;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Player1", new Position(1, 1), 0, Color.BLUE);
        player2 = new Player("Player2", 0, 0, 0, Color.RED);
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

    @Test
    public void testResetCar() {
        player1.getCar().setCollided();
        player1.resetCar(new Position(0, 0), 0);
        assertFalse(player1.getCar().isCollided());
    }

    @Test
    public void testToJsonNormal() {
        try {
            JSONObject p1 = player1.toJson();
            String name = p1.getString(Player.JSON_NAME);
            assertEquals(name, player1.getName());
            int score = p1.getInt(Player.JSON_SCORE);
            assertEquals(score, player1.getScore());
            int RGB = p1.getInt(Player.JSON_COLOR);
            assertEquals(RGB, player1.getCar().getColor().getRGB());
        } catch (JSONException e) {
            fail();
        }
    }
}
