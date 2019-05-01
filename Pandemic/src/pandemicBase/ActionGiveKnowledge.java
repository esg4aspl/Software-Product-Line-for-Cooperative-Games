package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBaseRoles.Researcher;
import rules.RuleBothOfPlayersMustBeInSameCity;
import rules.RuleThereMustBeCityCardMatchesCurrentCity;

public class ActionGiveKnowledge extends AbstractAction {
	private AbstractPlayer takerPlayer;
	public ActionGiveKnowledge( AbstractReferee referee,AbstractPlayer takerPlayer) {
		super("Give Knowledge","Give the City card that matches the city you are in to another player. \n" + 
				"The other player must also be in the city with you. Both of you need to agree to do this. \n" 
				, referee);
		this.takerPlayer = takerPlayer;
		addRule(new RuleBothOfPlayersMustBeInSameCity());
		addRule(new RuleThereMustBeCityCardMatchesCurrentCity());
	}
	public AbstractPlayer getTakerPlayer() {
		return takerPlayer;
	}
	@Override
	public void takeAction() {
		
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
