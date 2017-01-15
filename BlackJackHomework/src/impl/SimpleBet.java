package impl;

public class SimpleBet implements BettingStrategy{

	@Override
	public boolean decision(BlackJackPlayer player) {
		if (player.getHand().valueOf()>16){
    		return false;
    	}
		return true;
	}
}
