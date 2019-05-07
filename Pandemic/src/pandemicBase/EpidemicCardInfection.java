package pandemicBase;

import core.AbstractBoard;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractGamePiece;
import core.AbstractInfection;
import core.AbstractReferee;
import core.Color;
import core.ICubeList;
import core.IRule;
import rules.RuleThereMustBeNoCubeOnNodeForEpidemic;

public class EpidemicCardInfection extends AbstractInfection {

	public EpidemicCardInfection(AbstractReferee referee) {
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
		Color color = ((BoardNode) cityToBeInfected).getColor();
		ICubeList cubeList = referee.getCubeList();
		infectCity(cityToBeInfected,cubeList,color);
	}

	@Override
	protected boolean didOutbreakOccur(AbstractBoardNode cityToBeInfected) {
		IRule rule = new RuleThereMustBeNoCubeOnNodeForEpidemic(cityToBeInfected);
		return !rule.evaluate(referee);
	}

	@Override
	protected void putDiseaseCubesToNode(AbstractBoardNode cityToBeInfected, ICubeList cubeList, Color color) {
		AbstractGamePiece cube = cubeList.takeCubeFromCubeList(color);
		((BoardNode)cityToBeInfected).addPieceOnNode(cube);
		if(((BoardNode)cityToBeInfected).howManyCubesDoesHave()<2){
			cube = cubeList.takeCubeFromCubeList(color);
			((BoardNode)cityToBeInfected).addPieceOnNode(cube);
		}
	}

}
