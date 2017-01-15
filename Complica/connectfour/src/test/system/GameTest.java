package test.system;

import exc.GameStateException;
import exc.IllegalMoveException;
import impl.GameFactory;

public class GameTest {
    public static void main(String[] args) throws NumberFormatException, GameStateException, IllegalMoveException {    	
    	System.out.print("got here");
    	GameFactory factory = new GameFactory();
    	//game gets started when created in the factory 
    	factory.createGame("connectfour", "graphical");
    }
}
