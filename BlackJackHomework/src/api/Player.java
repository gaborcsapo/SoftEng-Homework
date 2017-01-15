package api;

/*
 * A card player.
 */
public interface Player extends Comparable<Player> {
    /*
     * Receive an individual card
     */
    public void receive(Card card);

    /*
     * Receive a hand
     */
    public void receive(Hand hand);

    /*
     * Return the current hand to the caller
     */
    public Hand getHand();

    /*
     * Place a wager
     */
    public double wager();

    /*
     * Give a player money (upon winning a round)
     */
    public void payOut(double money);


    /*
     * Return the amount of money currently available to the player
     */
    public double getMoney();

    /*
     * Return the name of the player
     */
    public String getName();

    /*
     * Whether the player would like request a card: an affirmative
     * return value indicates the player would; otherwise
     * not. (Essentially a request to 'hit' in Black Jack.)
     */
    public boolean requestCard();
}
