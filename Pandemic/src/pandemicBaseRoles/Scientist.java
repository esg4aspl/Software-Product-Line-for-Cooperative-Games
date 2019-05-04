package pandemicBaseRoles;

import core.AbstractRole;
import rules.RuleThereMustBeFourCardsOfSameColor;
import rules.RuleThereMustBeResearchStationAtCurrentCity;

public class Scientist extends AbstractRole {
	public Scientist() {
		super("Scientist","-You need only 4 cards of the same color to do the Discover a Cure action");
		this.addRule(new RuleThereMustBeResearchStationAtCurrentCity());
		this.addRule(new RuleThereMustBeFourCardsOfSameColor());

	}
	
}
