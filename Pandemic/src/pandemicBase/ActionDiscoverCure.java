package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.ICureMarkerList;
import core.IRule;
import pandemicBaseRoles.Scientist;
import rules.RuleDiseaseMustNotBeCuredYet;
import rules.RuleThereMustBeFiveCardsOfSameColor;
import rules.RuleThereMustBeResearchStationAtCurrentCity;

public class ActionDiscoverCure extends AbstractAction {
	private Color diseaseColor;
	public ActionDiscoverCure(AbstractReferee referee,Color diseaseColor) {
		super("DiscoverCure","At any research station, discard 5 City cards of the same color from your hand to cure the disease of that color." 
				+" If no cubes of this color are on the board, this disease is now eradicated. ",referee);
		this.diseaseColor = diseaseColor;
		addRule(new RuleThereMustBeResearchStationAtCurrentCity());
		addRule(new RuleThereMustBeFiveCardsOfSameColor());
		addRule(new RuleDiseaseMustNotBeCuredYet(diseaseColor));

	}

	@Override
	public void takeAction() {
		Player currentPlayer = (Player) referee.getCurrentPlayer();
		PlayerHand playerHand = (PlayerHand)currentPlayer.getHand();
		Color colorOfCards;
		if(currentPlayer.getRole() instanceof Scientist) {
			colorOfCards = playerHand.getColorOfCardsNeededToFindCure(4);
			currentPlayer.discardCard(colorOfCards, 4);
		}
		else {
			colorOfCards = playerHand.getColorOfCardsNeededToFindCure(5);
			currentPlayer.discardCard(colorOfCards, 5);

		}
		ICureMarkerList cureMarkerList = referee.getCureMarkerList();
		CureMarker cureMarker= (CureMarker) cureMarkerList.getMarkerByColor(colorOfCards);
		cureMarker.cureDisease();
	}

	@Override
	public List<IRule> getRuleList() {
		AbstractPlayer player = referee.getCurrentPlayer();
		if(player.getRole() instanceof Scientist) {
			player.getRole().getRuleList().add(new RuleDiseaseMustNotBeCuredYet(diseaseColor));
			return  player.getRole().getRuleList();
		}
		return ruleList;
	}

}
