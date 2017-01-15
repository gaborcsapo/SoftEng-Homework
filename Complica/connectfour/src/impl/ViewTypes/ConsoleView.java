package impl.ViewTypes;

import java.util.Observable;

import api.Game;
import api.View;
import util.Chip;

public class ConsoleView extends View {
	public void render(Game game) {
		Chip[][] board = game.getBoard();
		System.out.println(game.getCurrentPlayer() + "\n");
		for (int i = 0; i< game.getColumns(); i++){
			System.out.print(" " + i);
		}
		System.out.print("\n");
		for (int row = game.getRows()-1; row >= 0; row--){
			for (int col = 0; col <= game.getColumns() - 1; col++){
				switch (board[row][col].toString()) {
				case "0x0000ffff":
					System.out.print("|O");
					break;
				case "0xff0000ff":
					System.out.print("|X");
					break;
				case "0x00000000":
					System.out.print("| ");
					break;
				default:
					break;
				}

			}
			System.out.print("|\n");
			for (int col = 0; col < game.getColumns() + 1; col++){
				System.out.print("--");

			}
			System.out.print("\n");

		}
	}


	public void update(Observable o, Object arg) {
		render((Game) o);
	}
}
