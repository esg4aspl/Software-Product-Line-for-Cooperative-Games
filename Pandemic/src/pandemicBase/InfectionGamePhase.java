package pandemicBase;

import core.AbstractBoard;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractInfection;
import core.AbstractReferee;
import core.AbstractTrack;
import core.Color;
import core.ICubeList;


public class InfectionGamePhase extends AbstractInfection {

	public InfectionGamePhase(AbstractReferee referee) {
		super(referee);
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
		AbstractTrack outbreakTrack = referee.getOutbreakTrack();
		infectCity(cityToBeInfected,cubeList,colorOfCityToBeInfected,outbreakTrack);
	}
}
