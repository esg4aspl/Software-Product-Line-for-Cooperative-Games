package rules;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.AbstractActionShareKnowledge;


public class RuleBothOfPlayersMustBeInSameCity implements IRule {
	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractAction currentAction = referee.getCurrentAction();
		AbstractPlayer otherPlayer = ((AbstractActionShareKnowledge)currentAction).getOtherPlayer();
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		if(currentPlayer.getCurrentNode().equals(otherPlayer.getCurrentNode())) {
			return true;
		}
		return false;
	}

}
