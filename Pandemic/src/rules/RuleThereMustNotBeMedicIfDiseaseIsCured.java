package rules;


import java.util.List;
import core.AbstractBoardNode;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.ICureMarkerList;
import core.IRule;
import pandemicBase.BoardNode;
import pandemicBase.CureMarker;
import pandemicBaseRoles.Medic;

//I don't know if the rule should be like this. 
public class RuleThereMustNotBeMedicIfDiseaseIsCured implements IRule {
	AbstractBoardNode cityToBeInfected; 
	public RuleThereMustNotBeMedicIfDiseaseIsCured(AbstractBoardNode cityToBeInfected) {
		this.cityToBeInfected = cityToBeInfected;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		ICureMarkerList cureMarkerList = referee.getCureMarkerList();
		Color colorOfCityToBeInfected = ((BoardNode) cityToBeInfected).getColor();
		if(isDiseaseCured(cureMarkerList,colorOfCityToBeInfected) && isThereMedicOnNode(cityToBeInfected)) {
			return false;
		}
		return true;
	}
	private boolean isThereMedicOnNode(AbstractBoardNode boardNode) {
		List<AbstractPlayer> playerListOfBoardNode = ((BoardNode)boardNode).getPlayersOnNode();
		for (AbstractPlayer player : playerListOfBoardNode) {
			if(player.getRole() instanceof Medic) {
				return true;
			}
		}
		return false;
	}
	private boolean isDiseaseCured(ICureMarkerList cureMarkerList,Color colorOfDisease) {
		CureMarker cureMarker= (CureMarker) cureMarkerList.getMarkerByColor(colorOfDisease);
		return cureMarker.isCured();
	}

}
