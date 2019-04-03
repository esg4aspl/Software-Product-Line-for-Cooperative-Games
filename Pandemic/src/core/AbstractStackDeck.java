package core;

import java.util.List;
import java.util.Stack;

public abstract class AbstractStackDeck extends AbstractDeck{

	public AbstractStackDeck(List<AbstractCard> deck) {
		super(deck);
	}
	public AbstractCard drawTheCardOnTopFromTheDeck() { // Player ve Infection Deck i�in method...
		return ((Stack<AbstractCard>)this.getDeck()).pop();
	}

}
