package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBaseRoles.OperationsExpert;
import rules.RuleThereMustBeCityCardMatchesCurrentCity;


public class ActionBuildResearchStation  extends AbstractAction {

	public ActionBuildResearchStation(AbstractReferee referee) {
		super("BuildResearchStation","Discard the City card that matches the city you are in to place a research station there.", referee);
		addRule(new RuleThereMustBeCityCardMatchesCurrentCity());
		
	}

	@Override
	public void takeAction() {

		
	}

	@Override
	public List<IRule> getRuleList() {
		AbstractPlayer player = referee.getCurrentPlayer();
		if(player.getRole() instanceof OperationsExpert) {
			return  player.getRole().getRuleList();
		}
		return ruleList;
	}

}
