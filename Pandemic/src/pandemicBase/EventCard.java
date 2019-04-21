package pandemicBase;

import core.AbstractCard;
import core.Event;

public class EventCard extends AbstractCard {
	private Event event;
	public EventCard(Event event) {
		super(event.getName());
		this.event = event;
	}
	
	public String toString() {
		return event.toString();
		
	}

}
