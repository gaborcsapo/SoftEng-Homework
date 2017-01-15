package impl;

import java.util.Scanner;

import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;
import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import util.Chip;

public abstract class GameTemplate extends Game {
	protected int _round = 0;
	protected BoardChecker Checker = new BoardChecker(this);
	protected Chip winner = new Chip();
	protected Chip CurrentPlayer = new Chip();
	Scanner scanner = new Scanner(System.in);
	private int rows;
    private int columns;
    protected Chip[][] surface;
    
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Chip[][] getBoard() {
        return surface;
    }

	public GameTemplate(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		surface = new Chip[rows][columns];
		for (int i = 0; i < getRows(); i++){
			for (int j = 0; j < getColumns(); j++){
				surface[i][j] = new Chip();
			}
		}
	}
    
    public Chip getCurrentPlayer() {
    	if (_round%2 == 0)
			CurrentPlayer.set(Color.BLUE);
		else
			CurrentPlayer.set(Color.RED);
    	return CurrentPlayer;
	}
    
    public boolean isGameOver() {
    	if (!winner.is(Color.TRANSPARENT)){
			setChanged();
			notifyObservers();
			return true;
		}
    	return false;
	}
     
    public Chip getWinningPlayer() throws GameStateException {
		if (winner.is(Color.TRANSPARENT))
			throw new GameStateException();
    	return winner;
	}
    
    //required for the different view implementations
    
    public void bindToWinningPlayer(ObjectProperty<Paint> property) {
		property.bind(this.winner);		
	}
    
    public void round() throws NumberFormatException, GameStateException, IllegalMoveException{
    	setChanged();
    	notifyObservers();
    	System.out.print("Enter column number: ");
    	placeDisk(Integer.parseInt(scanner.nextLine()));
    }
  
    //template method
    public void placeDisk(int col) throws GameStateException, IllegalMoveException {
    	wrongColumn(col);
    	for (int i = 0; i < getRows()+1; i++){
    		if (i == getRows()){
    			fullColumn(col, i);
    			checkWinner(col, i);
    		}
    		else if	(surface[i][col].is(Color.TRANSPARENT)){
    			emptyColumn(col, i);
    			checkWinner(col, i);
    			break;
    		}		
    	}	
	}

    //methods used in the template method
    
	protected abstract void checkWinner(int col, int row);

	protected abstract void fullColumn(int col, int row) throws IllegalMoveException;
	
	public void emptyColumn(int col, int row) {
		surface[row][col].setValue(getCurrentPlayer());
	}

	public void wrongColumn(int col) throws IllegalMoveException {
		if (col > this.getColumns()-1 || col < 0)
    		throw new IllegalMoveException();
	}
}
