package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBaseRoles.OperationsExpert;
import rules.RuleThereMustBeCityCardMatchesCurrentCity;
import rules.RuleThereMustNotBeResearchStationAtCurrentCity;


public class ActionBuildResearchStation  extends AbstractAction {

	public ActionBuildResearchStation(AbstractReferee referee) {
		super("BuildResearchStation","Discard the City card that matches the city you are in to place a research station there.", referee);
		addRule(new RuleThereMustBeCityCardMatchesCurrentCity());
		addRule(new RuleThereMustNotBeResearchStationAtCurrentCity());
		
	}

	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		((BoardNode)currentNode).addPieceOnNode(new ResearchStation());
		if(!(currentPlayer.getRole() instanceof OperationsExpert)) {
			AbstractCard discardedCard=((Player)currentPlayer).discardCard(currentNode.getName());
			referee.getPlayerDiscardPile().addCardToDeck(discardedCard);
		} 
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
