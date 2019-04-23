package core;

public enum ActionType {
	DriveOrFerry("DriveOrFerry","Move to a city connected by a white line to the one you are in."),
	DirectFlight("DirectFlight","Discard a City card to move to the city named on the card."),
	CharterFlight("CharterFlight","Discard the City card that matches the city you are in to move to any city."),
	ShuttleFlight("ShuttleFlight","Move from a city with a research station to any other city that has a research station."),
	BuildResearchStation("BuildResearchStation","Discard the City card that matches the city you are in to place a research station there."
			+"Take the research station from the pile next to the board. If all 6 research stations have been built, take a research station from anywhere on the board."),
	TreatDisease("TreatDisease","Remove 1 disease cube from the city you are in, placing it in the cube \n" + 
			"supply next to the board. If this disease color has been cured , remove all cubes of that color from the city you are in." + 
			"If the last cube of a cured disease is removed from the board, this disease is eradicated. "),
	ShareKnowledge("ShareKnowledge","You can do this action in two ways: \n" + 
			"give the City card that matches the city you are in to another player, or \n" + 
			"take the City card that matches the city you are in from another player. \n" + 
			"The other player must also be in the city with you. Both of you need to agree to do this. \n" + 
			"If the player who gets the card now has more than 7 cards, that player must immediately discard a card or play an Event card"),
	DiscoverCure("DiscoverCure","At any research station, discard 5 City cards of the same color from your hand to cure the disease of that color." 
			+" If no cubes of this color are on the board, this disease is now eradicated. ");
	
	private String name;
	private String text;
	
	private ActionType(String name,String text) {
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
		return name + ": " + text;
	}
}
