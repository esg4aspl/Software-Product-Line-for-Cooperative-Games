package rules;

import core.AbstractBoardNode;
import core.AbstractReferee;
import core.Color;
import core.ICureMarkerList;
import core.IRule;
import pandemicBase.CureMarker;
import pandemicBase.BoardNode;

public class RuleDiseaseMustBeNotEradicatedYet implements IRule {
	AbstractBoardNode cityToBeInfected; 
	public RuleDiseaseMustBeNotEradicatedYet(AbstractBoardNode cityToBeInfected) {
		this.cityToBeInfected = cityToBeInfected;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		Color colorOfCityToBeInfected = ((BoardNode)cityToBeInfected).getColor();
		ICureMarkerList cureMarkerList = referee.getCureMarkerList();
		CureMarker cureMarker = (CureMarker) cureMarkerList.getMarkerByColor(colorOfCityToBeInfected);
		return !cureMarker.isEradicated();
	}

}
