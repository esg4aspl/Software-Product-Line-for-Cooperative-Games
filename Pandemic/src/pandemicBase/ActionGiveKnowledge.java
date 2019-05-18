package pandemicBase;

import java.util.List;

import core.AbstractCard;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBaseRoles.Researcher;
import rules.RuleBothOfPlayersMustBeInSameCity;
import rules.RuleThereMustBeCityCardMatchesCurrentCityForCurrentPlayer;

public class ActionGiveKnowledge extends AbstractActionShareKnowledge {
	private AbstractCard card;
	public ActionGiveKnowledge( AbstractReferee referee,AbstractPlayer takerPlayer,AbstractCard card) {
		super("Give Knowledge","Give the City card that matches the city you are in to another player. \n" + 
				"The other player must also be in the city with you. Both of you need to agree to do this. \n" 
				, referee,takerPlayer);
		this.card = card;
		addRule(new RuleBothOfPlayersMustBeInSameCity());
		addRule(new RuleThereMustBeCityCardMatchesCurrentCityForCurrentPlayer());
	}
	
	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractCard givenCard = currentPlayer.discardCard(card);
		otherPlayer.addCardToHand(givenCard);
	}

	@Override
	public List<IRule> getRuleList() {
		AbstractPlayer giverPlayer = referee.getCurrentPlayer();
		if(giverPlayer.getRole() instanceof Researcher) {
			return giverPlayer.getRole().getRuleList();
		}
		return ruleList;
	}

}
