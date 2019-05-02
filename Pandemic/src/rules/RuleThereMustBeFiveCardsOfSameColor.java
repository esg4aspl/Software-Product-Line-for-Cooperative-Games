package rules;
import core.AbstractDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.PlayerHand;


public class RuleThereMustBeFiveCardsOfSameColor implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractPlayer player = referee.getCurrentPlayer();
		AbstractDeck playerHand = player.getHand();
		return ((PlayerHand)playerHand).areThereEnoughCardsOfSameColor(5);
	}
	
	
	
	
	
	
	
	

}
