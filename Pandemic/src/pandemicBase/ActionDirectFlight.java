package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import rules.RuleThereMustBeCityCardAtHand;

public class ActionDirectFlight extends AbstractAction {
	private BoardNode destinationNode;
	public ActionDirectFlight(AbstractReferee referee,BoardNode destinationNode) {
		super("DirectFlight","Discard a City card to move to the city named on the card.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleThereMustBeCityCardAtHand());
		
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
	public AbstractBoardNode getDestinationNode() {
		return destinationNode;
	}

}
