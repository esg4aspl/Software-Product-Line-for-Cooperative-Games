package pandemicBase;

import java.util.ArrayList;
import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.ICureMarkerList;
import core.IRule;
import pandemicBaseRoles.Scientist;
import rules.RuleDiseaseMustBeNotCuredYet;
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
		addRule(new RuleDiseaseMustBeNotCuredYet(diseaseColor));

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
		referee.setEndGame(cureMarkerList.areAllMarkersCured());
	}

	@Override
	public List<IRule> getRuleList() {
		List<IRule> newRuleList = new ArrayList<IRule>();
		AbstractPlayer player = referee.getCurrentPlayer();
		if(player.getRole() instanceof Scientist) {
			for(IRule rule:player.getRole().getRuleList()) {
				newRuleList.add(rule);
			}
			newRuleList.add(new RuleDiseaseMustBeNotCuredYet(diseaseColor));
			return  newRuleList;
		}
		return ruleList;
	}

}
