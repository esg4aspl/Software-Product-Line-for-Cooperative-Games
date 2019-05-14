package rules;

import core.AbstractBoardNode;
import core.AbstractHandDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;

public class RuleThereMustBeCityCardMatchesCurrentCityForCurrentPlayer implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractPlayer player = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = player.getCurrentNode();
		AbstractHandDeck playerHand = (AbstractHandDeck) player.getHand();
		System.out.println("CITY CARD CITY ILE MATCH MI?" + playerHand.doesHave(currentNode.getName()));
		return playerHand.doesHave(currentNode.getName());
		
		
	}
	
}


