package rules;

import core.AbstractDeck;
import core.AbstractReferee;
import core.IRule;

public class RuleThereMustBeEnoughPlayerCards implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractDeck playDeck = referee.getPlayerDeck();
		if(playDeck.size() != 0) {
			return true;
		}
		referee.setEndGame(true);
		return false;
	}

}
