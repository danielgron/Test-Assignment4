package dk.danielgron.slange.servicelayer.unittest;

import dk.danielgron.slange.datalayer.Direction;
import dk.danielgron.slange.datalayer.Player;
import dk.danielgron.slange.datalayer.Point;
import dk.danielgron.slange.servicelayer.GameManager;
import dk.danielgron.slange.servicelayer.GameManagerImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameManagerTest {

    @Test
    public void shouldCreateGame(){
        var gm = new GameManagerImpl(4);
        assertNotNull(gm.getBoard());
    }

    @Test
    public void shouldAddPlayer(){
        var gm = new GameManagerImpl(4);
        var playerAdded = gm.addPlayer(new Player(1));
        assertTrue(playerAdded);
    }

    @Test
    public void shouldNotAddPlayerIfMaxIs0(){
        var gm = new GameManagerImpl(0);
        var playerAdded = gm.addPlayer(new Player(1));
        assertFalse(playerAdded);
    }

    @Test
    void shouldTick(){
        var gm = new GameManagerImpl(0);
        var t1 = gm.tick();
        var t2 = gm.tick();

        assertEquals(1, t2 - t1);
    }

    @Test
    void shouldMovePlayerHeadsWhenTick(){
        var gm = new GameManagerImpl(2);
        var player1 = new Player(1);

        player1.setHead(new Point(2,4));
        player1.setHead(new Point(2,3));

        player1.setDirection(Direction.UP);

        gm.addPlayer(player1);

        var t1 = gm.tick();

        assertEquals(2, player1.getHead().getX());
        assertEquals(4, player1.getHead().getY());

    }

    @Test
    void shouldMovePlayerTailsWhenTick(){
        var gm = new GameManagerImpl(2);
        var player1 = new Player(1);

        player1.setHead(new Point(2,4));
        player1.setHead(new Point(2,3));

        player1.setDirection(Direction.LEFT);

        gm.addPlayer(player1);

        var t1 = gm.tick();

        assertEquals(2, player1.getTail().getX());
        assertEquals(3, player1.getTail().getY());

    }


}
