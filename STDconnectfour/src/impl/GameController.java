package impl;

import api.Controller;
import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;

public class GameController implements Controller {
	private Game gameModel;

	public GameController(Game game){
		this.gameModel = game;
	}

	public void handlePlaceDisk(int row, int col) {
		if (!gameModel.isGameOver())
			try {gameModel.placeDisk(col);} catch (GameStateException | IllegalMoveException e) {}
	}
}