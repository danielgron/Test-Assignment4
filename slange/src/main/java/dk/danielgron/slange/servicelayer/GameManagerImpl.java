package dk.danielgron.slange.servicelayer;

import dk.danielgron.slange.datalayer.Direction;
import dk.danielgron.slange.datalayer.Player;
import dk.danielgron.slange.datalayer.Point;

import static java.lang.Thread.sleep;

public class GameManagerImpl implements GameManager {


    //private final int maxPlayers;
    private Player[] players;
    private Point apple = new Point(5, 5);
    private int tick = 0;
    private boolean gameRunning;
    private int width = 30;
    private int height = 20;

    public GameManagerImpl(int maxPlayers, int width, int height) {

        players = new Player[maxPlayers];
        for (int i = 0; i < maxPlayers; i++) {
        }
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
        gameRunning = true;
        while (gameRunning){
            try {
                drawBoard();
                tick();
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void drawBoard() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width ; x++) {
                var hasPlayer = false;
                for (int i = 0; i < players.length; i++) {
                    var xLambda = x;
                    var yLambda = y;
                    if (players[i].getSnake().stream().anyMatch(p -> p.getX() == xLambda && p.getY() == yLambda))
                        hasPlayer = true;
                }
                if (hasPlayer)
                    System.out.print("[O]");
                else
                    System.out.print("[ ]");
            }
            System.out.println("");
        }

        System.out.println("");
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

            if (hasCollided(player))
                player.setAlive(false);

            player.moveTail();

        }
        return this.tick++;
    }

    public boolean hasCollided(Player player) {
        var insideBoundsX = player.getHead().getX() >= 0 && player.getHead().getX() < width;
        var insideBoundsY = player.getHead().getY() >= 0 && player.getHead().getY() < height;
        var hasSelfCollision = player.getSnake().subList(1, player.getSnake().size()).stream().anyMatch(x -> x.getX() == player.getHead().getX() && x.getY() == player.getHead().getY());

        return (!insideBoundsX || !insideBoundsY || hasSelfCollision);
    }

    @Override
    public int getCurrentGameTime() {
        return 0;
    }
}
