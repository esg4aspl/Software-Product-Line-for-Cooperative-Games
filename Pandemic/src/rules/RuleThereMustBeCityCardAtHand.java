package rules;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractHandDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import core.MovementAction;

public class RuleThereMustBeCityCardAtHand implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractAction currentAction = referee.getCurrentAction();
		AbstractPlayer player = referee.getCurrentPlayer();
		AbstractBoardNode destinationNode = currentAction.getDestinationNode();
		AbstractHandDeck playerHand = (AbstractHandDeck) player.getHand();
		return playerHand.doesHave(destinationNode.getName()) ;
	}

}
