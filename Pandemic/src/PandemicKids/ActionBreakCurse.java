package PandemicKids;

import core.AbstractBoardNode;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.ICubeList;
import pandemicBase.ActionTreatDisease;
import pandemicBase.CureMarker;

public class ActionBreakCurse extends ActionTreatDisease {

	public ActionBreakCurse(AbstractReferee referee, Color color) {
		super(referee, color);
	}
	public void takeAction() {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		ICubeList cubeList = referee.getCubeList();
		CurseMarkerList curseMarkerList = ((PandemicKidsReferee)referee).getCurseMarkerList();
		CureMarker cureMarker = (CureMarker) curseMarkerList.getMarkerByColor(diseaseColor);
		takeActionForNotCuredDisease(currentPlayer,currentNode,cubeList);
		
		if(isDiseaseEradicated()) {
			cureMarker.eradicateDisease();
		}
		referee.setEndGame(curseMarkerList.areAllCurseMarkersEradicated());
	}

}
