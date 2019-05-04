package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractBoard;
import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.ICubeList;
import core.ICureMarkerList;
import core.IRule;
import pandemicBaseRoles.Medic;
import rules.RuleThereMustBeAtLeastOneCubeAtCurrentCity;

public class ActionTreatDisease extends AbstractAction {
	Color diseaseColor;
	public ActionTreatDisease(AbstractReferee referee,Color color) {
		super("TreatDisease","Remove 1 disease cube from the city you are in, placing it in the cube \n" + 
				"supply next to the board. If this disease color has been cured , remove all cubes of that color from the city you are in." + 
				"If the last cube of a cured disease is removed from the board, this disease is eradicated. ", referee);
		this.diseaseColor = color;
		addRule(new RuleThereMustBeAtLeastOneCubeAtCurrentCity(diseaseColor));
		
	}

	@Override
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		ICubeList cubeList = referee.getCubeList();
		ICureMarkerList cureMarkerList = referee.getCureMarkerList();
		CureMarker cureMarker = (CureMarker) cureMarkerList.getMarkerByColor(diseaseColor);
		if(cureMarker.isCured()) {
			takeActionForCuredDisease(currentPlayer,currentNode,cubeList);
		}
		else {
			takeActionForNotCuredDisease(currentPlayer,currentNode,cubeList);
		}
		if(isDiseaseEradicated()) {
			cureMarker.eradicateDisease();
		}
	}

	@Override
	public List<IRule> getRuleList() {
		return ruleList;
	}
	private void addRemovedCubesToCubeList(ICubeList cubeList,List<AbstractGamePiece> cubeToBeRemovedList ) {
		for (AbstractGamePiece cube : cubeToBeRemovedList) {
			cubeList.addCubeToCubeList(cube);
		}
	}
	private boolean isDiseaseEradicated() {
		AbstractBoard board = referee.getBoard();
		List<AbstractBoardNode> nodeList = board.getNodeList();
		for (AbstractBoardNode node : nodeList) {
			if(((BoardNode)node).doesHaveSpecificColoredCube(diseaseColor)) {
				return false;
			}
		}
		return true;
	}
	private void takeActionForNotCuredDisease(AbstractPlayer currentPlayer,AbstractBoardNode currentNode,ICubeList cubeList) {
		List<AbstractGamePiece> cubesToBeRemoved = ((BoardNode)currentNode).removeCubesFromNode(diseaseColor,1);
		addRemovedCubesToCubeList(cubeList, cubesToBeRemoved);
		if(currentPlayer.getRole() instanceof Medic) {
			cubesToBeRemoved = ((BoardNode)currentNode).removeCubesFromNode(diseaseColor,2);
			addRemovedCubesToCubeList(cubeList, cubesToBeRemoved);
		}
	}
	private void takeActionForCuredDisease(AbstractPlayer currentPlayer,AbstractBoardNode currentNode,ICubeList cubeList) {
		List<AbstractGamePiece> cubesToBeRemoved = ((BoardNode)currentNode).removeCubesFromNode(diseaseColor,3);
		addRemovedCubesToCubeList(cubeList, cubesToBeRemoved);
	}
}
