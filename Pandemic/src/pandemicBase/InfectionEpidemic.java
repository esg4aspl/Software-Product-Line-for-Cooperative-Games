package pandemicBase;

import core.AbstractBoard;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractGamePiece;
import core.AbstractInfection;
import core.AbstractReferee;
import core.AbstractTrack;
import core.Color;
import core.ICubeList;
import core.IRule;
import rules.RuleThereMustBeNoCubeOfSameColorOnNodeForEpidemic;

public class InfectionEpidemic extends AbstractInfection {

	public InfectionEpidemic(AbstractReferee referee) {
		super(referee);
	}

	@Override
	public void infect() {
		InfectionTrack rateMarker = (InfectionTrack) referee.getInfectionTrack();
		rateMarker.moveMarker();
		
		InfectionDeck infectionDeck = (InfectionDeck) referee.getInfectionDeck();
		AbstractCard cityCard = infectionDeck.drawBottomCardFromDeck();
		InfectionDiscardPile infectionDiscardPile = (InfectionDiscardPile) referee.getInfectionDiscardPile();
		infectionDiscardPile.addCardToDeck(cityCard);
		infectionDiscardPile.shuffle();
		infectionDeck.addInfectionDiscardPile(infectionDiscardPile);
		
		AbstractBoard board = referee.getBoard();
		AbstractBoardNode cityToBeInfected = board.getBoardNode(cityCard.getName());
		Color colorOfCityToBeInfected = ((BoardNode) cityToBeInfected).getColor();
		ICubeList cubeList = referee.getCubeList();
		AbstractTrack outbreakTrack = referee.getOutbreakTrack();
		if(!didEpidemicCauseOutbreak(cityToBeInfected)) {
			infectUntilNodeHasThreeCubesOfSameColor(cityToBeInfected,cubeList,colorOfCityToBeInfected);
		}
		else {
			infectUntilNodeHasThreeCubesOfSameColor(cityToBeInfected,cubeList,colorOfCityToBeInfected);
			infectCity(cityToBeInfected,cubeList,colorOfCityToBeInfected,outbreakTrack);
		}
		
	}

	private boolean didEpidemicCauseOutbreak(AbstractBoardNode cityToBeInfected) {
		IRule rule = new RuleThereMustBeNoCubeOfSameColorOnNodeForEpidemic(cityToBeInfected);
		return !rule.evaluate(referee);
	}
	private void infectUntilNodeHasThreeCubesOfSameColor(AbstractBoardNode cityToBeInfected, ICubeList cubeList,Color color) {
		if(isSatisfied(cityToBeInfected)) {
			while(((BoardNode)cityToBeInfected).howManyCubesDoesHave(color)<3) {
				AbstractGamePiece cube = cubeList.takeCubeFromCubeList(color);
				((BoardNode)cityToBeInfected).addPieceOnNode(cube);
			}
		}
	}
	

}
