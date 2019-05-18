package pandemicBaseRoles;

import core.AbstractRole;
import rules.RuleThereMustNotBeResearchStationAtCurrentCity;
import rules.RuleNoConstriantNeeded;

public class OperationsExpert extends AbstractRole {
	public OperationsExpert() {
		super("Operations Expert","-As an aciton,build a research station in the city you are in (no city card needed) \n");
		addRule(new RuleNoConstriantNeeded());
		addRule(new RuleThereMustNotBeResearchStationAtCurrentCity());
	}
}
