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

public class ActionGiveKnowledge extends AbstractAction {
	private AbstractPlayer takerPlayer;
	private String cardName;
	public ActionGiveKnowledge( AbstractReferee referee,AbstractPlayer takerPlayer,String cardName) {
		super("Give Knowledge","Give the City card that matches the city you are in to another player. \n" + 
				"The other player must also be in the city with you. Both of you need to agree to do this. \n" 
				, referee);
		this.takerPlayer = takerPlayer;
		this.cardName = cardName;
		addRule(new RuleBothOfPlayersMustBeInSameCity());
		addRule(new RuleThereMustBeCityCardMatchesCurrentCity());
	}
	public AbstractPlayer getTakerPlayer() {
		return takerPlayer;
	}
	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractCard givenCard = currentPlayer.discardCard(cardName);
		takerPlayer.addCardToHand(givenCard);
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
