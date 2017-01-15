package impl;

import api.View;
import exc.GameStateException;
import exc.IllegalMoveException;
import javafx.application.Application;
import util.Chip;

public class GameFactory {
	GameTemplate game;
	
	//first I decide which view to use
	public void createGame (String gametype, String viewtype) throws NumberFormatException, GameStateException, IllegalMoveException{
		
		if (viewtype.equals("graphical")){
			//starting the application
    		Application.launch(GraphicalView.class, gametype);
    	}    	
    	if (viewtype.equals("console")){
    		//start consoleview
    		createGameType(gametype);
        	View view = new ConsoleView();
        	game.addObserver(view);
        	while (!game.isGameOver()) {
        		((GameTemplate) game).round();
        	}
        	try {
        		Chip winner = game.getWinningPlayer();
        		System.out.println("the winner is: " + winner);
        	}
        	catch (GameStateException e) {
        		System.out.println("It was a tie!");
        	}
    	} 
	}
	
	//here I create a gameTemplate depending on what the input is
	public GameTemplate createGameType(String gametype) {
		if (gametype.equals("complica")){
			game = new ComplicaGame();
		}
		if (gametype.equals("connectfour")){
			game = new ConnectFourGame();
		}
		return game;
	}
}
