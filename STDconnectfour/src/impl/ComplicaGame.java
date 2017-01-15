package impl;

import javafx.scene.paint.Color;
import util.Chip;

public class ComplicaGame extends GameTemplate{
	private Chip next = new Chip();

	public ComplicaGame() {
		super(7, 4);
	}
    
	//I need to access both player colors in order to compare who has more 4s
    private Chip getNextPlayer() {
    	if (_round%2 == 0)
			next.set(Color.RED);
		else
			next.set(Color.BLUE);
    	return next;
    }
    
     private int isThisWinner(Chip player){
    	int count = 0;
    	for (int currentrow = 0; currentrow< getRows(); currentrow++){
    		if (Checker.checkUpLeft(0, currentrow, player))
    			count++;
    		if (Checker.checkUpRight(0, currentrow, player))
    			count++;
    		if (Checker.checkRight(currentrow, player))
    			count++;
    	}
    	for (int currentcol = 0; currentcol < getColumns(); currentcol++)
    		if (Checker.checkUp(currentcol, player))
    			count++;
    	return count;
    }

	@Override
	public void checkWinner(int col, int row) {
		if (isThisWinner(getCurrentPlayer()) > isThisWinner(getNextPlayer())){
			winner.setValue(getCurrentPlayer());
			CurrentPlayer.set(Color.TRANSPARENT);
			return;
		}
    	if (isThisWinner(getCurrentPlayer()) < isThisWinner(getNextPlayer())){
			winner.setValue(getNextPlayer());
			CurrentPlayer.set(Color.TRANSPARENT);
			return;
		}
    	_round++;
		getCurrentPlayer();
	}

	
	public void fullColumn(int col, int row) {
		for (int q = 0; q < getRows()-1; q++){
			surface[q][col].setValue(surface[q+1][col]);	
		}
		surface[row-1][col].setValue(getCurrentPlayer());
	}
}
