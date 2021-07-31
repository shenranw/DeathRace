package test;

import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    public Position pos;

    @BeforeEach
    public void setUp() {
        pos = new Position(0, 0);
    }

    @Test
    public void testMoveXOnce() {
        pos.moveX(10);
        assertEquals(10, pos.getX());
        assertEquals(0, pos.getY());
    }

    @Test
    public void testMoveYOnce() {
        pos.moveY(10);
        assertEquals(10, pos.getY());
        assertEquals(0, pos.getX());
    }

    @Test
    public void testMoveXMoreThanOnce() {
        pos.moveX(10);
        pos.moveX(10);
        assertEquals(20, pos.getX());
        assertEquals(0, pos.getY());
    }

    @Test
    public void testMoveYMoreThanOnce() {
        pos.moveY(10);
        pos.moveY(10);
        assertEquals(0, pos.getX());
        assertEquals(20, pos.getY());
    }

    @Test
    public void testMoveXY() {
        pos.moveX(10);
        pos.moveY(20);
        assertEquals(10, pos.getX());
        assertEquals(20, pos.getY());
    }
}
