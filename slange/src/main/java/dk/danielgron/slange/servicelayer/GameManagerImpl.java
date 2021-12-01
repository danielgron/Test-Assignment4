package dk.danielgron.slange.servicelayer;

import dk.danielgron.slange.datalayer.Player;
import dk.danielgron.slange.datalayer.Point;

public class GameManagerImpl implements GameManager {


    //private final int maxPlayers;
    private Player[] players;
    private int tick = 0;

    public GameManagerImpl(int maxPlayers) {
        players = new Player[maxPlayers];
    }

    @Override
    public Player[][] getBoard() {
        return new Player[0][];
    }

    @Override
    public Player[] getPlayers() {
        return players;
    }

    @Override
    public boolean addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean movePlayer(Point p, Player player) {
        return false;
    }

    @Override
    public boolean startGame() {
        return false;
    }

    @Override
    public int tick() {
        for (var player: players) {
            if (player == null)
                continue;

            var x = player.getHead().getX();
            var y = player.getHead().getY();
            switch (player.getDirection()){
                case UP:
                    y += 1;
                    break;
                case DOWN:
                    y -= 1;
                    break;

                case LEFT:
                    x -= 1;
                    break;

                case RIGHT:
                    x += 1;
            }

            Point p = new Point(x, y);
            player.setHead(p);
            player.moveTail();

        }
        return this.tick++;
    }

    @Override
    public int getCurrentGameTime() {
        return 0;
    }
}
