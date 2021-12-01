package dk.danielgron.slange.servicelayer;

import dk.danielgron.slange.datalayer.Player;
import dk.danielgron.slange.datalayer.Point;

public interface GameManager {


    Player[][] getBoard();

    Player[] getPlayers();

    boolean addPlayer(Player player);

    boolean movePlayer(Point point, Player player);


    boolean startGame();

    /**
     * Increment game timer, and perform moves.
     * @return New Game Timer
     */
    int tick();


    /**
     * @return Current game time
     */
    int getCurrentGameTime();

}
