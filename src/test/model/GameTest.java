package test.model;

import main.model.Car;
import main.model.Game;
import main.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

//This class is the test class for Game
public class GameTest {

    public Game game;

    @BeforeEach
    public void setUp() {
        game = new Game("p1", "p2");
    }

    @Test
    public void testCommand() {
        Car c1 = game.getPlayer1().getCar();
        Car c2 = game.getPlayer2().getCar();
        game.command(KeyEvent.VK_KP_LEFT);
        assertEquals(270, c2.getDirection());
        game.command(KeyEvent.VK_LEFT);
        assertEquals(180, c2.getDirection());
        game.command(KeyEvent.VK_RIGHT);
        assertEquals(270, c2.getDirection());
        game.command(KeyEvent.VK_KP_RIGHT);
        assertEquals(360, c2.getDirection());
        game.command(KeyEvent.VK_A);
        assertEquals(270, c1.getDirection());
        game.command(KeyEvent.VK_D);
        assertEquals(360, c1.getDirection());
        for (int i = 0; i < Game.BOARD_Y; i++) {
            game.doGameCycle();
        }
        game.command(KeyEvent.VK_R);
        assertFalse(game.isEnd());
        assertEquals(0, game.getWalls().size());
        assertEquals(new ArrayList<>(), game.getWalls());
    }

    @Test
    public void testDoGameCycle() {
        ArrayList<Position> wall = new ArrayList<>();
        wall.add(game.getPlayer1().getCar().getPos());
        wall.add(game.getPlayer2().getCar().getPos());
        game.doGameCycle();
        for (int i = 0; i < wall.size(); i++) {
            assertEquals(wall.get(i).getX(), game.getWalls().get(i).getX());
            assertEquals(wall.get(i).getY() + 1, game.getWalls().get(i).getY());
        }
    }
}
