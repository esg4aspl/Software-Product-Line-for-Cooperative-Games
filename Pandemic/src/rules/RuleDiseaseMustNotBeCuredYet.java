package rules;

import core.AbstractReferee;
import core.Color;
import core.ICureMarkerList;
import core.IRule;
import pandemicBase.CureMarker;

public class RuleDiseaseMustNotBeCuredYet implements IRule {
	private Color diseaseColor;
	public RuleDiseaseMustNotBeCuredYet(Color diseaseColor) {
		this.diseaseColor = diseaseColor;
	}

	@Override
	public boolean evaluate(AbstractReferee referee) {
		ICureMarkerList cureMarkerList = referee.getCureMarkerList();
		CureMarker cureMarker = (CureMarker) cureMarkerList.getMarkerByColor(diseaseColor);
		return cureMarker.isCured();
	}
}
