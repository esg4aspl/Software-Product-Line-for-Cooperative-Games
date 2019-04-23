package rules;

import core.AbstractBoardNode;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import core.MovementAction;

public class RuleDestinationCityMustBeNeighborOfCurrentCity implements IRule{

	@Override
	public boolean evaluate(AbstractReferee referee) {
		MovementAction currentAction = (MovementAction) referee.getCurrentAction();
		AbstractPlayer player = currentAction.getPlayer();
		AbstractBoardNode destinationNode = currentAction.getDestinationNode();
		AbstractBoardNode currentNode = player.getCurrentNode();
		
		return destinationNode.isNeighbor(currentNode);
	}

}
