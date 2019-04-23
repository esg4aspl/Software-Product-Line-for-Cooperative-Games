package core;

import java.util.List;

public abstract class AbstractStackDeck extends AbstractDeck{

	public AbstractStackDeck(List<AbstractCard> deck) {
		super(deck);
	}
	public AbstractCard drawCardOnTopFromDeck() { // This method is necessary for drawing a card from Infection or Play Deck.
		int lastIndex = getDeck().size()-1;
		return this.getDeck().remove(lastIndex);
	}

}
