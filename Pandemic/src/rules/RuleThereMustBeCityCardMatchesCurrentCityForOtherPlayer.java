package rules;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractHandDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.AbstractActionShareKnowledge;

public class RuleThereMustBeCityCardMatchesCurrentCityForOtherPlayer implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractAction currentAction = referee.getCurrentAction();
		AbstractPlayer player = ((AbstractActionShareKnowledge)currentAction).getOtherPlayer();
		AbstractBoardNode currentNode = player.getCurrentNode();
		AbstractHandDeck playerHand = (AbstractHandDeck) player.getHand();
		System.out.println("CITY CARD CITY ILE MATCH MI?" + playerHand.doesHave(currentNode.getName()));
		return playerHand.doesHave(currentNode.getName());
	}

}
