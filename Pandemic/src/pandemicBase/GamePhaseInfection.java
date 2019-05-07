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
import rules.RuleThereMustBeLessThanThreeCubesOnNode;

public class GamePhaseInfection extends AbstractInfection {

	public GamePhaseInfection(AbstractReferee referee) {
		super(referee);
	}

	@Override
	protected boolean didOutbreakOccur(AbstractBoardNode cityToBeInfected) {
		IRule rule = new RuleThereMustBeLessThanThreeCubesOnNode(cityToBeInfected);
		return !rule.evaluate(referee);
	}

	@Override
	protected void putDiseaseCubesToNode(AbstractBoardNode cityToBeInfected, ICubeList cubeList, Color color) {
		AbstractGamePiece cube = cubeList.takeCubeFromCubeList(color);
		((BoardNode)cityToBeInfected).addPieceOnNode(cube);
	}

	@Override
	public void infect() {
		InfectionDeck infectionDeck = (InfectionDeck) referee.getInfectionDeck();
		AbstractBoard board = referee.getBoard();
		AbstractCard cityCard = infectionDeck.drawCardOnTopFromDeck();
		InfectionDiscardPile infectionDiscardPile = (InfectionDiscardPile) referee.getInfectionDiscardPile();
		infectionDiscardPile.addCardToDeck(cityCard);
		AbstractBoardNode cityToBeInfected = board.getBoardNode(cityCard.getName());
		Color colorOfCityToBeInfected = ((BoardNode) cityToBeInfected).getColor();
		ICubeList cubeList = referee.getCubeList();
		infectCity(cityToBeInfected,cubeList,colorOfCityToBeInfected);
	}
}
