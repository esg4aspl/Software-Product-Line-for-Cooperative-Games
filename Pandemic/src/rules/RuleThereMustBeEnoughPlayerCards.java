package rules;

import core.AbstractDeck;
import core.AbstractReferee;
import core.IRule;

public class RuleThereMustBeEnoughPlayerCards implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractDeck playerDeck = referee.getPlayerDeck();
		if(playerDeck.size() != 0) {
			return true;
		}
		System.out.println("VALLAHI DE TRUELADIK ENDI ENOUGHCARDS ICINDE");
		referee.setEndGame(true);
		return false;
	}

}
