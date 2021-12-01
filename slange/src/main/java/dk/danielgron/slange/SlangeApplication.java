package dk.danielgron.slange;

import dk.danielgron.slange.datalayer.Direction;
import dk.danielgron.slange.datalayer.Player;
import dk.danielgron.slange.datalayer.Point;
import dk.danielgron.slange.servicelayer.GameManagerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SlangeApplication {

    public static void main(String[] args) {

        var gm = new GameManagerImpl(1, 30, 20);
        var p = new Player(1);
        p.setHead(new Point(3, 3));
        p.setDirection(Direction.RIGHT);
        gm.addPlayer(p);
        gm.startGame();

        SpringApplication.run(SlangeApplication.class, args);
    }

}
