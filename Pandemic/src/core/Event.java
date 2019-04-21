package core;

public enum Event {
	Airlift("Airlift","Move any 1 pawn to any city. Get permission before moving Another player’s pawn.");
	
	private String name;
	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	private String text;
	
	private Event(String name, String text) {
		this.name = name;
		this.text = text;
	}
	
	public String toString() {
		return "You have " + name +" event card. Event cards can be played at any time"+
				", except in between drawing and resolving a card.\n" + text ; 
	}
}
