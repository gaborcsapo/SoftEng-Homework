package impl;

import api.Game;
import util.Chip;

public class BoardChecker {
	private Game o;
	
	public BoardChecker (Game game){
		this.o = game;
	}
	
	public boolean checkRight(int currentrow, Chip player) {
		int rowChecker = currentrow;
		int colChecker = 0;
		int ChipCount = 0;
		Chip Player = player;
		
		while (colChecker<= o.getColumns()-1){
			if (o.getBoard()[rowChecker][colChecker].equals(Player)){
				ChipCount++;
			} 
			else {
				ChipCount = 0;
			}
			if (ChipCount == 4){
				return true;
			}
			colChecker++;
		}
		return false;
	}
	
	public boolean checkUp(int currentcol, Chip player) {
		int rowChecker = 0;
		int colChecker = currentcol;
		int ChipCount = 0;
		Chip Player = player;
		
		while (rowChecker<= o.getRows()-1){
			if (o.getBoard()[rowChecker][colChecker].equals(Player)){
				ChipCount++;
			} 
			else {
				ChipCount = 0;
			}
			if (ChipCount == 4){
				return true;
			}
			rowChecker++;
		}
		return false;
	}

	public boolean checkUpRight(int currentcol, int currentrow, Chip player) {
		int rowChecker = currentrow;
		int colChecker = currentcol;
		int ChipCount = 0;
		Chip Player = player;
		
		while (rowChecker < o.getRows()-1 && colChecker < o.getColumns()-1){
			colChecker++;
			rowChecker++;
		}
		while (colChecker >= 0 && rowChecker >= 0){
			if (o.getBoard()[rowChecker][colChecker].equals(Player)){
				ChipCount++;
			} 
			else {
				ChipCount = 0;
			}
			if (ChipCount == 4){
				return true;
			}
			colChecker--;
			rowChecker--;
		}
		return false;
	}
	

	public boolean checkUpLeft(int currentcol, int currentrow, Chip player) {
		int rowChecker = currentrow;
		int colChecker = currentcol;
		int ChipCount = 0;
		Chip Player = player;
		
		while (rowChecker< o.getRows()-1 && colChecker > 0){
			colChecker--;
			rowChecker++;
		}
		while (colChecker <= o.getColumns()-1 && rowChecker >= 0){
			if (o.getBoard()[rowChecker][colChecker].equals(Player)){
				ChipCount++;
			} else {
				ChipCount = 0;
			}
			if (ChipCount == 4){
				return true;
			}
			colChecker++;
			rowChecker--;
		}
		return false;
	}
}
