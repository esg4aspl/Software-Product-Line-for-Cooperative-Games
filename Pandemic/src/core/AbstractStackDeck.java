package core;

import java.util.List;

public abstract class AbstractStackDeck extends AbstractDeck{

	public AbstractStackDeck(List<AbstractCard> deck) {
		super(deck);
	}
	public AbstractCard drawCardOnTopFromDeck() { // This method is necessary for drawing a card from Infection or Play Deck.
		int lastIndex = getDeck().size()-1;
		return deck.remove(lastIndex);
	}
	public AbstractCard getCardOnTop() {
		int lastIndex = getDeck().size()-1;
		return deck.get(lastIndex);
	}
	public void drawCardOnTopFromDeck(AbstractCard card) { // This method is necessary for drawing a card from Infection or Play Deck.
		this.getDeck().remove(card);
	}

}
