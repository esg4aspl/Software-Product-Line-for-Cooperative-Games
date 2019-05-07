package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractCard;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBaseRoles.Researcher;
import rules.RuleBothOfPlayersMustBeInSameCity;
import rules.RuleThereMustBeCityCardMatchesCurrentCity;

public class ActionTakeKnowledge extends AbstractAction {
	private AbstractPlayer giverPlayer;
	private String cardName;
	public ActionTakeKnowledge( AbstractReferee referee,AbstractPlayer giverPlayer,String cardName) {
		super("Take Knowledge","Take the City card that matches the city you are in from another player. \n" + 
				"The other player must also be in the city with you. Both of you need to agree to do this. \n" + 
				"If the player who gives the card is Researcher then no need to take the city card matches the city you are in.", referee);
		this.giverPlayer = giverPlayer;
		this.cardName = cardName;
		addRule(new RuleBothOfPlayersMustBeInSameCity());
		addRule(new RuleThereMustBeCityCardMatchesCurrentCity());
	}

	public AbstractPlayer getGiverPlayer() {
		return giverPlayer;
	}
	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractCard takenCard = giverPlayer.discardCard(cardName);
		currentPlayer.addCardToHand(takenCard);
	}

	@Override
	public List<IRule> getRuleList() {
		if(giverPlayer.getRole() instanceof Researcher) { // If giverPlayer is Researcher there is no need to control the checking card.
			return giverPlayer.getRole().getRuleList();
		}
		return ruleList;
	}

}
