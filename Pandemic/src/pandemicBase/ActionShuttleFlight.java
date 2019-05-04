package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import rules.RuleDestionationAndSourceCitiesMustHaveResearchStation;

public class ActionShuttleFlight  extends AbstractAction {
	private BoardNode destinationNode;
	public ActionShuttleFlight( AbstractReferee referee,BoardNode destinationNode) {
		super("ShuttleFlight","Move from a city with a research station to any other city that has a research station.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleDestionationAndSourceCitiesMustHaveResearchStation());
		
	}

	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		currentPlayer.setCurrentNode(destinationNode);
		destinationNode.addPlayersOnTheNode(currentPlayer);
	}

	@Override
	public List<IRule> getRuleList() {
		return ruleList;
	}

	public AbstractBoardNode getDestinationNode() {
		
		return destinationNode;
	}

}
