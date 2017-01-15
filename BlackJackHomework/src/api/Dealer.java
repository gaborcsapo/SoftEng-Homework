package api;

import java.util.List;

/*
 * A card dealer, and the maestro of the table
 */
public interface Dealer {
    /*
     * Deal a single card to a player
     */
    public void dealCard(Player player);
    
    /*
     * Deal cards to all players at the table. Note that in Black
     * Jack, that also means the dealer themself!
     */
    public void dealTable(List<Player> players);
    
    /*
     * Collect all cards from a single player.
     */
    public void collectCards(Player player);
    
    /*
     * Collect cards from all players at the table. Note that in Black
     * Jack, that also means the dealer themself!
     */
    public void collectCards(List<Player> players);
    
    /*
     * Get the hand of the dealer.
     */
    public Hand getHand();
}
