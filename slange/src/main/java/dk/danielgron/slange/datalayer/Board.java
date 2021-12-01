package dk.danielgron.slange.datalayer;

public class Board {
    private Player[][] board;

    public Board(){

    }

    public Board(int sizeX, int sizeY){
        board = new Player[sizeX][sizeY];
    }

}
