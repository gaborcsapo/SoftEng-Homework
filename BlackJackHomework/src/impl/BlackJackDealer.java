package impl;

import java.util.List;
import api.Card;
import api.Dealer;
import api.Hand;
import api.Player;

import java.util.ArrayList;
import java.util.Collections;
import impl.BlackJackHand;
import impl.BlackJackPlayer;

/*
 * A card dealer, and the maestro of the table
 */
public class BlackJackDealer extends BlackJackPlayer implements Dealer{
	
	private List<Card> deck = new ArrayList<Card>();
	
	/*
	 * Constructor method for a dealer, creates deck of cards
	 */
	public BlackJackDealer(String name){
		super(name);
		for (Card.Value value: Card.Value.values()){
			for (Card.Suit suit: Card.Suit.values()){
				deck.add(new Card(value, suit));
			}
		}
	}
	
	/*
	 * Deal a single card to a player
	 */
	public void dealCard(Player player) {
		player.receive(deck.remove(0));
	}

	/*
	 * Deal cards to all players at the table. Note that in Black
	 * Jack, that also means the dealer themself!
	 */
	public void dealTable(List<Player> players) {
		List<Player> CopyPlayers = new ArrayList<Player>(players);
		CopyPlayers.add(this);
		Collections.shuffle(deck);
		for (Player temp: CopyPlayers) {
			temp.receive(new BlackJackHand(deck.remove(0), deck.remove(0)));
		}
                /**
                 * jsw7 If the dealer is truly a player, then she
                 *      should be dealt a hand during regular game
                 *      play. The way it's done here, the dealer is
                 *      actually playing the game!
                 **/
		while (this.requestCard()) {
			this.dealCard(this);
		}
	}

	/*
	 * Collect all cards from a single player.
	 */
	public void collectCards(Player player) {
		for (Card card: player.getHand().getCards()){
			deck.add(card);
		}
	}

	/*
	 * Collect cards from all players at the table. Note that in Black
	 * Jack, that also means the dealer themself!
	 */
	public void collectCards(List<Player> players) {
		List<Player> CopyPlayers = new ArrayList<Player>(players);
		CopyPlayers.add(this);
		for (Player temp: CopyPlayers) {
			collectCards(temp);
		}
	}

	/*
	 * Get the hand of the dealer.
	 */
    /**
     * jsw7 ERR4 Why not use your parent?
     * 
     * gc1569 corrected
     **/
	public Hand getHand() {
		return super.getHand();
	}
}
