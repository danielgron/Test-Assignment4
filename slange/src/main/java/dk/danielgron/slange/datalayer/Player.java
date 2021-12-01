package dk.danielgron.slange.datalayer;

import jdk.jshell.spi.ExecutionControl;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private boolean alive = true;
    private String name;
    private LinkedList<Point> snake;
    private int id;
    private Direction direction;

    public int getId(){
        return id;
    };

    public boolean getAlive(){
        return alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public Player(int id){
        snake = new LinkedList<>();
        this.id = id;
    }

    public Point getHead(){
        return snake.getFirst();
    }

    public Point getTail(){
        return snake.getLast();
    }

    public boolean setHead(Point p){
        snake.addFirst(p);
        return true;
    }

    public List<Point> getSnake(){
        return snake;
    }



    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveTail() {
        snake.removeLast();
    }
}
