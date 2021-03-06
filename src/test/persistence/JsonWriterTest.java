package test.persistence;

import main.model.Player;
import main.persistence.JsonReader;
import main.persistence.JsonWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

//This class is the test class for JsonWriter
public class JsonWriterTest {

    public Player player1;
    public Player player2;
    public HashSet<Player> playerList;
    public HashSet<Player> readList;
    public JsonWriter writer;
    public JsonReader reader;

    @BeforeEach
    public void setUp() {
        player1 = new Player("p1", 0, 0, 0, Color.red);
        player2 = new Player("p2", 0, 0, 0, Color.green);
        playerList = new HashSet<>();
        playerList.add(player1);
        playerList.add(player2);
    }

    @Test
    public void testWrite() {
        try {
            writer = new JsonWriter("./data/writerTest.json");
            reader = new JsonReader("./data/writerTest.json");
            writer.open();
            writer.write(playerList);
            writer.close();
            readList = reader.read();
            Player[] readArray = (Player[]) readList.toArray();
            assertTrue(playerList.contains(readArray[0]));
            assertTrue(playerList.contains(readArray[1]));
        } catch (IOException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testWriteFileNotFound() {
        try {
            writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Exception should be thrown");
        } catch (FileNotFoundException e) {
            //success
        }
    }
}
