package pandemicBase;

import java.util.List;

import core.AbstractCard;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBaseRoles.Researcher;
import rules.RuleBothOfPlayersMustBeInSameCity;
import rules.RuleThereMustBeCityCardMatchesCurrentCityForOtherPlayer;

public class ActionTakeKnowledge extends AbstractActionShareKnowledge {
	private AbstractCard card;
	public ActionTakeKnowledge( AbstractReferee referee,AbstractPlayer giverPlayer,AbstractCard card) {
		super("Take Knowledge","Take the City card that matches the city you are in from another player. \n" + 
				"The other player must also be in the city with you. Both of you need to agree to do this. \n" + 
				"If the player who gives the card is Researcher then no need to take the city card matches the city you are in.", referee,giverPlayer);
		this.card = card;
		addRule(new RuleBothOfPlayersMustBeInSameCity());
		addRule(new RuleThereMustBeCityCardMatchesCurrentCityForOtherPlayer());
	}

	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractCard takenCard = otherPlayer.discardCard(card);
		currentPlayer.addCardToHand(takenCard);
	}

	@Override
	public List<IRule> getRuleList() {
		if(otherPlayer.getRole() instanceof Researcher) { // If giverPlayer is Researcher there is no need to control the checking card.
			return otherPlayer.getRole().getRuleList();
		}
		return ruleList;
	}

}
