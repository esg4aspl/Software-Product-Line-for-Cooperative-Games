package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import rules.RuleThereMustBeCityCardMatchesCurrentCity;

public class ActionCharterFlight extends AbstractAction {
	private BoardNode destinationNode;
	public ActionCharterFlight(AbstractReferee referee,BoardNode destinationNode) {
		super("CharterFlight","Discard the City card that matches the city you are in to move to any city.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleThereMustBeCityCardMatchesCurrentCity());
	}
	
	

	public BoardNode getDestinationNode() {
		return destinationNode;
	}

	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		currentPlayer.setCurrentNode(destinationNode);
		destinationNode.addPlayersOnTheNode(currentPlayer);
		currentPlayer.discardCard(destinationNode.getName());
	}

	@Override
	public List<IRule> getRuleList() {
		
		return ruleList;
	}

}
