package impl;

import api.Table;
import api.Player;
import impl.BlackJackDealer;
import impl.BlackJackPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * The table class represents a place in which card games happen. You
 * should specialize it specifically for Black Jack.
 */
public class BlackJackTable extends Table{
	/*
	 * A list of players
	 */
    /**
     * jsw7 ERR4 Already defined in the parent
     * 
     * gc1569 corrected
     **/
	

	/*
	 * The dealer
	 */
    /**
     * jsw7 ERR4 Already defined in the parent
     * 
     * gc1569 corrected
     **/
	

	/*
	 * Keeps track of wagers made during a round
	 */
    /**
     * jsw7 ERR4 Already defined in the parent
     * 
     * gc1569 corrected
     **/
	
	/*
	 * Constructor method for BlackJackTables
	 */
	
	public BlackJackTable(int NumberOfPlayers){
		this.players = new ArrayList<Player>();
		this.wagers = new HashMap<Player, Double>();
        /**
        * jsw7 Players should have unique names!
        * 
        * in line 63 I add a number at the end of the name so it is unique
        **/
		List<String> names = Arrays.asList("Bush", "Donald", "Bernie", "Obama", "Hillary");
		for (int i = 1; i < NumberOfPlayers+1; i++) {
			Double x = Math.floor(i/names.size());
			Player toAdd = new BlackJackPlayer(names.get(i%names.size()) + x.intValue());
			players.add(toAdd);
		}
		dealer = new BlackJackDealer("Mr. Dealer");	
	}

	/*
	 * A game is over when there are no players, or no players with
	 * money to bet
	 */
	public boolean isGameOver() {
		return players.isEmpty();
	}

	/*
	 * A string representation of the table
	 */
	public String toString() {
		String text = "\nPlayer name - money at the end - value of hand in the round\nMr. Dealer - " + dealer.getHand().valueOf() + "\n";
		for (Player temp: players){
			StringBuilder str = new StringBuilder(text);	    
			str.append(temp.getName() + " - " + temp.getMoney() + " - " + temp.getHand().valueOf() + "\n");
			text = "" + str;
		}
		return text;
	}

	/*
	 * A method that brings together actions of a round
	 */
    /**
     * jsw7 ERR4 Already defined in the parent
     * 
     * gc1569 corrected
     **/
	

	/*
	 * Collect bets from all players at the table
	 */
	protected void collectBets() {
		for (Player temp: players) {
			wagers.put(temp, temp.wager());
		}
	}


	/*
	 * Give each player a turn. Note that in Black Jack, the dealer
	 * should have a turn as well!
	 */
	protected void playerTurns() {
		for (Player temp: players) {
			while (temp.requestCard()) {
				dealer.dealCard(temp);
			}
		}
	}

	/*
	 * Evaluate each players hand with respect the rules of the game,
	 * and to the dealer. If a player has a winning hand, they should
	 * be paid based on their respective information in the wager
	 * table.
	 */
	protected void playerEvaluations() {
		List<Player> CopyPlayers = new ArrayList<Player>(players);
		for (Player temp: CopyPlayers) {
			//decision tree for determining the winner
			if (temp.getHand().isWinner()){
				if (dealer.getHand().isWinner()){
					continue;
				} else {
					temp.payOut(2*wagers.get(temp));
				}
			} else if (temp.getHand().isValid()){
				if (dealer.getHand().isValid()){
					if (temp.getHand().valueOf() > dealer.getHand().valueOf()){
						temp.payOut(2*wagers.get(temp));
					}
				} else {
					temp.payOut(2*wagers.get(temp));
				}
			}

			//determining if still in the game
			if (temp.getMoney()< 10){
                            /**
                             * jsw7 The correct way to do this
                             *      (in-place removal) is use a
                             *      traditional iterator, not for-each
                             *      
                             * gc1569 Looked into how iterators work, but I didn't want to mess around... Next time I'll use it.
                             **/
				players.remove(temp);
			}
		}
	}
}
