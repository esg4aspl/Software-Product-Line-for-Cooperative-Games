package pandemicBaseRoles;

import core.AbstractRole;

public class Medic extends AbstractRole {

	public Medic() {
		super("Medic","The Medic removes all cubes, not 1, of the same color  when doing the Treat Disease action.\n" + 
				"If a disease has been cured, he automatically removes all cubes of that color from a city, simply by entering it or being there." +
				"This does not take an action.\n" + 
				"The Medic also prevents placing disease cubes (and outbreaks) of cured diseases in his location.");
	// this class must add its own rules. 
	}
	
}
