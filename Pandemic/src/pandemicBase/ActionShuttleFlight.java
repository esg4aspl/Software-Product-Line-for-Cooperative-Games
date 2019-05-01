package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractReferee;
import core.IRule;
import rules.RuleDestionationAndSourceCitiesMustHaveResearchStation;

public class ActionShuttleFlight  extends AbstractAction {
	private BoardNode destinationNode;
	public ActionShuttleFlight(String name, String text,BoardNode destinationNode, AbstractReferee referee) {
		super(name, text, referee);
		this.destinationNode = destinationNode;
		addRule(new RuleDestionationAndSourceCitiesMustHaveResearchStation());
		
	}

	@Override
	public void takeAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IRule> getRuleList() {
		return ruleList;
	}

	public AbstractBoardNode getDestinationNode() {
		
		return destinationNode;
	}

}
