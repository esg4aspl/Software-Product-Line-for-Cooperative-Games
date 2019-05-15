package rules;

import core.AbstractDeck;
import core.AbstractReferee;
import core.IRule;

public class RuleThereMustBeEnoughPlayerCards implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractDeck playerDeck = referee.getPlayerDeck();
		if(playerDeck.size() != 1) {
			return true;
		}
		referee.setEndGame(true);
		return false;
	}

}
