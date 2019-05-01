package rules;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;

public class RuleDestinationCityMustBeNeighborOfCurrentCity implements IRule{

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractAction currentAction = referee.getCurrentAction();
		AbstractPlayer player = referee.getCurrentPlayer();
		AbstractBoardNode destinationNode = currentAction.getDestinationNode();
		AbstractBoardNode currentNode = player.getCurrentNode();
		
		return destinationNode.isNeighbor(currentNode);
	}

}
