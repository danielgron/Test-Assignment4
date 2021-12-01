package dk.danielgron.slange.datalayer.unittest;

import dk.danielgron.slange.datalayer.Player;
import dk.danielgron.slange.datalayer.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void shouldSetHead(){
        Player player = new Player(1);
        Point p = new Point(2,3);

        player.setHead(p);
        var result = player.getHead();

        assertEquals(p, result);
    }

    @Test
    public void shouldUpdateHead(){
        Player player = new Player(1);
        Point p1 = new Point(2,3);
        Point p2 = new Point(2,4);
        Point p3 = new Point(2,5);

        player.setHead(p1);
        player.setHead(p2);
        player.setHead(p3);
        var result = player.getHead();

        assertEquals(p3, result);
    }

    @Test
    public void shouldKeepTail(){
        Player player = new Player(1);
        Point p1 = new Point(2,3);
        Point p2 = new Point(2,4);
        Point p3 = new Point(2,5);

        player.setHead(p1);
        player.setHead(p2);
        player.setHead(p3);
        var result = player.getTail();

        assertEquals(p1, result);
    }
}
