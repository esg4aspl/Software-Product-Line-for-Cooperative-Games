package pandemicBaseRoles;

import core.AbstractRole;
import rules.RuleBothOfPlayersMustBeInSameCity;

public class Researcher extends AbstractRole {
	public Researcher() {
		super("Researcher","-As an action,you may give (or a player can take) any City card from your hand.\r\n You must both be in the same city.The card does not have to match the city you are in.");
		addRule(new RuleBothOfPlayersMustBeInSameCity());
	}
}
