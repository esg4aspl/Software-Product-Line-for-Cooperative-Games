package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.ICureMarkerList;
import core.IRule;
import pandemicBaseRoles.Medic;
import rules.RuleThereMustBeCityCardMatchesCurrentCityForCurrentPlayer;

public class ActionCharterFlight extends AbstractAction {
	private BoardNode destinationNode;
	public ActionCharterFlight(AbstractReferee referee,BoardNode destinationNode) {
		super("CharterFlight","Discard the City card that matches the city you are in to move to any city.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleThereMustBeCityCardMatchesCurrentCityForCurrentPlayer());
	}
	
	

	public BoardNode getDestinationNode() {
		return destinationNode;
	}

	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		((BoardNode)currentNode).removePlayer(currentPlayer);
		currentPlayer.setCurrentNode(destinationNode);
		destinationNode.addPlayersOnTheNode(currentPlayer);
		currentPlayer.discardCard(currentNode.getName());

		//If disease is cured, Medic removes them automatically by just being there.
		ICureMarkerList cureMarkerList=referee.getCureMarkerList();
		List<AbstractGamePiece> curedOnes = cureMarkerList.getCuredMarkers();
		if(curedOnes.size()!=0 && currentPlayer.getRole() instanceof Medic) {
			removeAllCubesOfSameColorIfDiseaseIsCuredAndCurrentPlayerIsMedic(curedOnes,currentPlayer);
		}
	}

	@Override
	public List<IRule> getRuleList() {
		
		return ruleList;
	}
	private void removeAllCubesOfSameColorIfDiseaseIsCuredAndCurrentPlayerIsMedic(List<AbstractGamePiece> curedOnes,AbstractPlayer player) {
		for (AbstractGamePiece marker : curedOnes) {
			Color cubeColor = ((CureMarker)marker).getColor();
			if(destinationNode.doesHaveSpecificColoredCube(cubeColor)) {
				int numOfCubesToBeRemoved = destinationNode.howManyCubesDoesHave(cubeColor);
				destinationNode.removeCubesFromNode(cubeColor, numOfCubesToBeRemoved);
			}
		}
	}
}
