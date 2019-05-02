package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractDeck;
import core.AbstractHandDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import rules.RuleThereMustBeCityCardAtHand;

public class ActionDirectFlight extends AbstractAction {
	private BoardNode destinationNode;
	public ActionDirectFlight(String name, String text,BoardNode destinationNode, AbstractReferee referee) {
		super("DirectFlight","Discard a City card to move to the city named on the card.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleThereMustBeCityCardAtHand());
		
	}
	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		currentPlayer.setCurrentNode(destinationNode);
		destinationNode.addPlayersOnTheNode(currentPlayer);
		AbstractCard discardedCard=currentPlayer.discardCard(destinationNode.getName());
		referee.getPlayerDiscardPile().addCardToDeck(discardedCard);
		
	}
	@Override
	public List<IRule> getRuleList() {
		return ruleList;
	}
	public AbstractBoardNode getDestinationNode() {
		return destinationNode;
	}

}
