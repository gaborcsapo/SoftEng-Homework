package test.unit.gc1569;
import org.junit.Test;

import api.Game;
import exc.GameStateException;
import exc.IllegalMoveException;
import impl.ComplicaGame;
import impl.GameTemplate;
import util.Chip;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ComplicaTest {
	@Test
	public void testColumnNotBounded() throws GameStateException, IllegalMoveException{
		GameTemplate game = new ComplicaGame();
		game.placeDisk(0);
		Chip first = new Chip(game.getBoard()[0][0]);
		for (int i = 0; i < game.getRows(); i++){
			game.placeDisk(0);
		}
		Chip second = new Chip(game.getBoard()[0][0]);
		assertNotEquals(first, second);
	}
	
	@Test
	public void testNoWinnerIfBothHaveFour() throws GameStateException, IllegalMoveException{
		GameTemplate game = new ComplicaGame();
		for (int i = 0; i < 3; i++){
			game.placeDisk(i);
			game.placeDisk(i);
		}
		game.placeDisk(2);
		for (int i = 0; i < game.getRows()+1; i++){
			game.placeDisk(3);
		}
		assertTrue(!game.isGameOver());
	}
	
	@Test
    public void testInitSetsPlayer() {
        Game game = new ComplicaGame();
        Chip chip = game.getCurrentPlayer();
        assertNotEquals(chip, Chip.INITIAL_COLOR);
    }

    @Test
    public void testInitBlanksBoard() {
        Game game = new ComplicaGame();
        Chip[][] surface = game.getBoard();

        for (int row = 0; row < game.getRows(); row++) {
            for (int col = 0; col < game.getColumns(); col++) {
                Chip chip = surface[row][col];
                assertTrue(chip.is(Chip.INITIAL_COLOR));
            }
        }
    }

    @Test
    public void testInitSetsRows() {
        Game game = new ComplicaGame();
        assertEquals(game.getRows(), 7);
    }

    @Test
    public void testInitSetsColumns() {
        Game game = new ComplicaGame();
        assertEquals(game.getColumns(), 4);
    }

    @Test
    public void testNextPlayerSetAfterPlacedDisk()
        throws GameStateException,
               IllegalMoveException {
        Game game = new ComplicaGame();
        
        Chip firstPlayer = new Chip(game.getCurrentPlayer());
        game.placeDisk(0);
        Chip secondPlayer = new Chip(game.getCurrentPlayer());
        
        assertNotEquals(firstPlayer, secondPlayer);
    }

    @Test(expected = IllegalMoveException.class)
    public void testDisksCannotBePlacedOutOfBounds()
        throws GameStateException,
               IllegalMoveException {
        Game game = new ComplicaGame();
        
        Chip firstPlayer = game.getCurrentPlayer();
        game.placeDisk(game.getColumns() + 1);
    }

    @Test(expected = IllegalMoveException.class)
    public void testDisksCannotBePlacedNegatively()
        throws GameStateException,
               IllegalMoveException {
        Game game = new ComplicaGame();
        
        Chip firstPlayer = game.getCurrentPlayer();
        game.placeDisk(-1);
    }
    
    @Test
    public void testVerticalWinnerFound() throws GameStateException,
                                                 IllegalMoveException {
        Game game = new ComplicaGame();

        for (int i = 0; i < 7; i++) {
            game.placeDisk(i % 2);
        }
        
        assertTrue(game.isGameOver());
    }

    @Test
    public void testHorizontalWinnerFound() throws GameStateException,
                                                   IllegalMoveException {
        Game game = new ComplicaGame();

        for (int i = 0; i < 4; i++) {
            int stop = (i < 3) ? 2 : 1;
            for (int j = 0; j < stop; j++) {
                game.placeDisk(i);
            }
        }
        
        assertTrue(game.isGameOver());
    }

    @Test
    public void testOutofOrderHorizontalWinnerFound()
        throws GameStateException,
               IllegalMoveException {
        Game game = new ComplicaGame();

        for (int i = 0; i < 4; i++) {
            if (i != 1) {
                for (int j = 0; j < 2; j++) {
                    game.placeDisk(i);
                }
            }
        }
        game.placeDisk(1);
        
        assertTrue(game.isGameOver());
    } 
   
}
