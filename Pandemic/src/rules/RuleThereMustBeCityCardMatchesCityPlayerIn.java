package rules;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractHandDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;

public class RuleThereMustBeCityCardMatchesCityPlayerIn implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractPlayer player = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = player.getCurrentNode();
		AbstractHandDeck playerHand = (AbstractHandDeck) player.getHand();
		return playerHand.doesHave(currentNode.getName());
		
		
	}
	
}


