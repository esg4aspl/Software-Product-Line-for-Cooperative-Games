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
import rules.RuleDestinationCityMustBeNeighborOfCurrentCity;

public class ActionDriveFerry extends AbstractAction {
	private BoardNode destinationNode;

	public ActionDriveFerry(AbstractReferee referee,BoardNode destinationNode) {
		super("DriveOrFerry","Move to a city connected by a white line to the one you are in.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleDestinationCityMustBeNeighborOfCurrentCity());

	}
	
	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		((BoardNode)currentNode).removePlayer(currentPlayer);
		currentPlayer.setCurrentNode(destinationNode);
		destinationNode.addPlayersOnTheNode(currentPlayer);
		
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
	
	public BoardNode getDestinationNode() {
		return this.destinationNode;
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
