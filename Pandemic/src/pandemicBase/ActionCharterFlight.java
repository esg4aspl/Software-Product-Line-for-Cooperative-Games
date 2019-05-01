package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractReferee;
import core.IRule;
import rules.RuleThereMustBeCityCardMatchesCurrentCity;

public class ActionCharterFlight extends AbstractAction {
	private BoardNode destinationNode;
	public ActionCharterFlight(String name, String text,BoardNode destinationNode, AbstractReferee referee) {
		super("CharterFlight","Discard the City card that matches the city you are in to move to any city.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleThereMustBeCityCardMatchesCurrentCity());
	}
	
	

	public BoardNode getDestinationNode() {
		return destinationNode;
	}

	@Override
	public void takeAction() {
		
	}

	@Override
	public List<IRule> getRuleList() {
		
		return ruleList;
	}

}
