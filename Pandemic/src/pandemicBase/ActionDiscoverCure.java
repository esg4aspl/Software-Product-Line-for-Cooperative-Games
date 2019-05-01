package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBaseRoles.Scientist;
import rules.RuleThereMustBeFiveCardsOfSameColor;
import rules.RuleThereMustBeResearchStationAtCurrentCity;

public class ActionDiscoverCure extends AbstractAction {

	public ActionDiscoverCure(AbstractReferee referee) {
		super("DiscoverCure","At any research station, discard 5 City cards of the same color from your hand to cure the disease of that color." 
				+" If no cubes of this color are on the board, this disease is now eradicated. ",referee);
		addRule(new RuleThereMustBeResearchStationAtCurrentCity());
		addRule(new RuleThereMustBeFiveCardsOfSameColor());
	}

	@Override
	public void takeAction() {
	}

	@Override
	public List<IRule> getRuleList() {
		AbstractPlayer player = referee.getCurrentPlayer();
		if(player.getRole() instanceof Scientist) {
			return  player.getRole().getRuleList();
		}
		return ruleList;
	}

}
