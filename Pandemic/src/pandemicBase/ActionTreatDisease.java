package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractReferee;
import core.IRule;
import rules.RuleThereMustBeAtLeastOneCubeAtCurrentCity;

public class ActionTreatDisease extends AbstractAction {

	public ActionTreatDisease(AbstractReferee referee) {
		super("TreatDisease","Remove 1 disease cube from the city you are in, placing it in the cube \n" + 
				"supply next to the board. If this disease color has been cured , remove all cubes of that color from the city you are in." + 
				"If the last cube of a cured disease is removed from the board, this disease is eradicated. ", referee);
		addRule(new RuleThereMustBeAtLeastOneCubeAtCurrentCity());
		
	}

	@Override
	public void takeAction() {
		

	}

	@Override
	public List<IRule> getRuleList() {
		return ruleList;
	}

}
