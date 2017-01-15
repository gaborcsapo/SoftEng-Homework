package impl;

import api.Player;
import api.Card;
import api.Hand;
import impl.BlackJackPlayer;

/*
 * A card player.
 */
public class BlackJackPlayer implements Player {
	/*
	 * Constructor method for a player
	 */
	public BlackJackPlayer(){
		this.PlayerHand = new BlackJackHand();
	};
	
	public BlackJackPlayer(String name){
		PlayerName = name;
		this.PlayerHand = new BlackJackHand();
	}
	
	/*
	 * name, money, hand of character is stored here
	 */
	private String PlayerName = "";
	private int PlayerMoney = 100;
	public Hand PlayerHand= new BlackJackHand();
	
	
    /*
     * Receive an individual card
     */
    public void receive(Card card) {
    	PlayerHand.addCard(card);
	}

    /*
     * Receive a hand
     */
    public void receive(Hand hand) {
    	PlayerHand = hand;
	}

    /*
     * Return the current hand to the caller
     */
    public Hand getHand() {
		return PlayerHand;
	}

    /*
     * Place a wager
     */
    public double wager() {
    	PlayerMoney -= 10;
		return 10;
	}

    /*
     * Give a player money (upon winning a round)
     */
    public void payOut(double money) {
    	PlayerMoney += money;
	}


    /*
     * Return the amount of money currently available to the player
     */
    public double getMoney() {
		return PlayerMoney;
	}

    /*
     * Return the name of the player
     */
    public String getName() {
		return PlayerName;
	}

    /*
     * Whether the player would like request a card: an affirmative
     * return value indicates the player would; otherwise
     * not. (Essentially a request to 'hit' in Black Jack.)
     */
    public boolean requestCard() {
    	if (PlayerHand.valueOf()>16){
    		return false;
    	}
		return true;
	}

    /**
     * jsw7 If two players have the same hand, they'll be considered
     *      equal! The reason we have compareTo is so that players can
     *      be stored in a Java collection; thus, you want players to
     *      be as unequal as possible.
     **/
	@Override
	public int compareTo(Player o) {
		int vCompare = this.getHand().compareTo(o.getHand());
		return vCompare;
	}
}
