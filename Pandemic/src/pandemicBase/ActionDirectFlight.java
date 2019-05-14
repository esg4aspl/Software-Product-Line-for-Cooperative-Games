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
import rules.RuleThereMustBeCityCardAtHand;

public class ActionDirectFlight extends AbstractAction {
	private BoardNode destinationNode;
	public ActionDirectFlight(AbstractReferee referee,BoardNode destinationNode) {
		super("DirectFlight","Discard a City card to move to the city named on the card.", referee);
		this.destinationNode = destinationNode;
		addRule(new RuleThereMustBeCityCardAtHand());
		
	}
	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		((BoardNode)currentNode).removePlayer(currentPlayer);
		currentPlayer.setCurrentNode(destinationNode);
		destinationNode.addPlayersOnTheNode(currentPlayer);
		currentPlayer.discardCard(destinationNode.getName());
		
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
	public AbstractBoardNode getDestinationNode() {
		return destinationNode;
	}
	private void removeAllCubesOfSameColorIfDiseaseIsCuredAndCurrentPlayerIsMedic(List<AbstractGamePiece> curedOnes,AbstractPlayer player) {
		for (AbstractGamePiece marker : curedOnes) {
			Color cubeColor = ((Cube)marker).getColor();
			if(destinationNode.doesHaveSpecificColoredCube(cubeColor)) {
				int numOfCubesToBeRemoved = destinationNode.howManyCubesDoesHave(cubeColor);
				destinationNode.removeCubesFromNode(cubeColor, numOfCubesToBeRemoved);
			}
		}
	}

}
