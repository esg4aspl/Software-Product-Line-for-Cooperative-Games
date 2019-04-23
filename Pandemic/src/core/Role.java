package core;
/*
 * This enum class is important to provide selected Roles to user.
 */
public enum Role {
	
	MEDIC("Medic","The Medic removes all cubes, not 1, of the same color  when doing the Treat Disease action.\n" + 
			"If a disease has been cured, he automatically removes all cubes of that color from a city, simply by entering it or being there." +
			"This does not take an action.\n" + 
			"The Medic also prevents placing disease cubes (and outbreaks) of cured diseases in his location."+ 
			"The Medic’s automatic removal of cubes can occur on other players’ turns, if he is moved by the Dispatcher or the Airlift Event."),	
	
	DISPATCHER("Dispatcher", "The Dispatcher may, as an action, either:\n " + 
			"-move any pawn, if its owner agrees, to any city containing another pawn, or \n" +
			"-move another player’s pawn, if its owner agrees,as if it were his own." + 
			"When moving a player’s pawn as if it were your own, discard cards for Direct and Charter Flights from your hand." + 
			"A card discarded for a Charter Flight must match the city the pawn is moving from."),
	
	QUARANTINASPECIALIST("Quarantine Specialist","Prevent disease cube placements (and outbreaks) in the city you are in all cities connected to it."),
	
	CONTIGENCYPLANNER("Contingency Planner","-As an action,take any discarded Event card and store it on this card.\n"+
						"-When you play the stored Event card,remove it from the game.\n"+
			            "Limit: 1 Event card on this card at a time,which is not part of your hand."),
	
	RESEARCHER("Researcher","-As an action,you may give (or a player can take) any City card from your hand. You must both be in the same city.The card does not have to match the city you are in."),
	
	SCIENTIST("Scientist","-You need only 4 cards of the same color to do the Discover a Cure action"),
	
	OPERATIONSEXPERT("Operations Expert","-As an aciton,build a research station in the city you are in (no city card needed) \n" +
						"-Once per turn as an action,move from a research station to any city by discarding any City Card.");
	
	
	private String name;
	private String text;
	
	private Role(String name, String text) {
		this.name = name;
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "You are " + name + "! " + 
				"Don't forget your special abilities:"  + text;
		
	} 
}
