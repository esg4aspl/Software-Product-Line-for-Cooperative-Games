package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import rules.RuleDestinationCityMustBeNeighborOfCurrentCity;

public class ActionDriveFerry extends AbstractAction {
	private BoardNode destinationNode;

	public ActionDriveFerry(String name, String text,BoardNode destinationNode, AbstractReferee referee) {
		super("DriveOrFerry","Move to a city connected by a white line to the one you are in.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleDestinationCityMustBeNeighborOfCurrentCity());

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
	
	public BoardNode getDestinationNode() {
		return this.destinationNode;
	}

}
