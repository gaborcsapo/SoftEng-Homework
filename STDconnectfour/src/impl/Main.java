package impl;

import api.View;
import api.Controller;
import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;
import javafx.application.Application;
import util.Chip;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) throws NumberFormatException, GameStateException, IllegalMoveException {    	
    	GameFactory factory = new GameFactory();
    	//game gets started when created in the factory 
    	factory.createGame(args[0], args[1]);
    }
}
