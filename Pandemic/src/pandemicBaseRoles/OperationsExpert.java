package pandemicBaseRoles;

import core.AbstractRole;
import rules.RuleThereMustNotBeResearchStationAtCurrentCity;
import rules.RuleNoConstriantNeeded;

public class OperationsExpert extends AbstractRole {
	public OperationsExpert() {
		super("Operations Expert","-As an aciton,build a research station in the city you are in (no city card needed) \n" +
				"-Once per turn as an action,move from a research station to any city by discarding any City Card.");
		addRule(new RuleNoConstriantNeeded());
		addRule(new RuleThereMustNotBeResearchStationAtCurrentCity());
	}
}
