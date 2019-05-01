package pandemicBaseRoleCards;

import core.AbstractRole;
public class Dispatcher extends AbstractRole {

	public Dispatcher() {
		super("Dispatcher", "The Dispatcher may, as an action, either:\n " + 
				"-move any pawn, if its owner agrees, to any city containing another pawn, or \n" +
				"-move another player’s pawn, if its owner agrees,as if it were his own." + 
				"When moving a player’s pawn as if it were your own, discard cards for Direct and Charter Flights from your hand." + 
				"A card discarded for a Charter Flight must match the city the pawn is moving from.");
	}
}
