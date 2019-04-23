package rules;

import core.AbstractBoardNode;
import core.AbstractHandDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import core.MovementAction;

public class RuleThereMustBeCityCardMatchesCityPlayerIn implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		
		MovementAction currentAction = (MovementAction) referee.getCurrentAction();
		AbstractPlayer player = currentAction.getPlayer();
		AbstractBoardNode currentNode = player.getCurrentNode();
		AbstractHandDeck playerHand = (AbstractHandDeck) player.getHand();
		return playerHand.doesHave(currentNode.getName());
		
		
	}
	
}


