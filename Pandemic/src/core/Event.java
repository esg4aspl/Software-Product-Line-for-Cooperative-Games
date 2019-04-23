package core;

public enum Event {
	Airlift("Airlift","Move any 1 pawn to any city. Get permission before moving Another player’s pawn."),
	OneQuietNight("One Quiet Night","Skip the next infect cities step"),
	ResilentPopulation("Resilent Population","Remove any 1 card in the infection discard pile from the game.You may play this between the infect and intensify steps of an epidemic."),
	Forecast("Forecast","Draw,look at and rearrange the top 6 cards of the infection deck.Put them back on top"),
	GovernmentGrant("Gouverment Grant","Add 1 research station to any city (no city card needed)");
	
	
	
	private String name;
	private String text;
	

	private Event(String name, String text) {
		this.name = name;
		this.text = text;
	}
	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}
	
	public String toString() {
		return "You have " + name +" event card. Event cards can be played at any time"+
				", except in between drawing and resolving a card.\n" + text ; 
	}
}
