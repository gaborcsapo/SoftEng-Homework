package impl;

import java.util.TreeSet;

import api.Card;
import api.Hand;

/*
 * A hand is a collection of cards.
 */
public class BlackJackHand extends Hand {
	/*
	 * Constructor for a hand
	 */
	public BlackJackHand(){
		this.cards = new TreeSet<Card>();
	};
	
	public BlackJackHand(Card card1, Card card2){
		this.cards = new TreeSet<Card>();
		cards.add(card1);
		cards.add(card2);
	}
	

	/*
	 * Adds a card to the hand
	 */
    /**
     * jsw7 ERR4 Already defined in the parent
     * 
     * gc1569 corrected
     **/
	

	/*
	 * Returns the set of cards 
	 */
    /**
     * jsw7 ERR4 Already defined in the parent
     * 
     * gc1569 corrected
     **/
	

	/*
	 * Determination of valid and winning hands, respectively. Your
	 * implementation should answer that question with respect to the
	 * rules of Black Jack, but irrespective of what other players at
	 * the table have (including the dealer).
	 */
    /**
     * jsw7 Why not just return the value of the comparison?
     * 
     * gc1569 corrected
     **/
	public boolean isValid() {
		return this.valueOf()>21;
		
	}
	public boolean isWinner() {
		return this.valueOf() == 21;
	}

	/*
	 * The value of the hand, as an integer.
	 */
	public int valueOf() {
		int sum = 0;
		for (Card card: cards){
			sum += card.getValue().getValue();
		}
		return sum;
	}

	
	public int compareTo(Hand o) {
		int vCompare = Integer.compare(this.valueOf(), o.valueOf());
		return vCompare;
	}
}

