package impl.GameTypes;

import exc.IllegalMoveException;
import impl.GameTemplate;
import javafx.scene.paint.Color;

public class ConnectFourGame extends GameTemplate{

	public ConnectFourGame() {
		super(6, 7);
	}
    
    public boolean isThisWinner(int currentcol, int currentrow){
  		if (Checker.checkUpLeft(currentcol, currentrow, getCurrentPlayer()) || Checker.checkUpRight(currentcol, currentrow, getCurrentPlayer()) || Checker.checkUp(currentcol, getCurrentPlayer()) || Checker.checkRight(currentrow, getCurrentPlayer())){
  			return true;
		}
		return false;
	}
    
    //I'm overriding the original implementation, because I also need to check whether the board is full or not
    public boolean isGameOver() {
    	//CHECK WINNER
    	if (!winner.is(Color.TRANSPARENT)){
			setChanged();
			notifyObservers();
			return true;
		}
    	//CHECK IF BOARD IS FULL
    	if (_round == getRows()*getColumns()){
    		CurrentPlayer.set(Color.TRANSPARENT);
    		return true;
    	}
    	return false;
	}

	@Override
	protected void checkWinner(int col, int row) {
		if (isThisWinner(col, row)){
			winner.setValue(getCurrentPlayer());
			CurrentPlayer.set(Color.TRANSPARENT);
			return;
		}
		_round++;
		getCurrentPlayer();
	}

	@Override
	protected void fullColumn(int col, int row) throws IllegalMoveException {
		throw new IllegalMoveException();
	}
}