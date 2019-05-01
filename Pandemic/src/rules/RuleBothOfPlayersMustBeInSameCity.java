package rules;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.ActionTakeKnowledge;


public class RuleBothOfPlayersMustBeInSameCity implements IRule {
	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractAction currentAction = referee.getCurrentAction();
		AbstractPlayer otherPlayer = ((ActionTakeKnowledge)currentAction).getGiverPlayer();
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		if(currentPlayer.getCurrentNode().equals(otherPlayer.getCurrentNode())) {
			return true;
		}
		return false;
	}

}
