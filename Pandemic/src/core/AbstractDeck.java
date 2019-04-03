package core;

import java.util.*;

public abstract class AbstractDeck {
	private List<AbstractCard> deck;
	public AbstractDeck(List<AbstractCard> deck) {
		createDeck(deck);
	}
	protected List<AbstractCard> getDeck() {
		return deck;
	}
	private void createDeck(List<AbstractCard> deck) {// Stack, Queue kullan�m� i�in. 
		this.deck = deck;
	}
	public void addCardToTheDeck(AbstractCard c) {
		this.deck.add(c);
	}
	/* Play, player ve infection decklerin remove i�lemi i�in signaturelar� farkl� oldu�u i�in 
	 * bu class� extend eden classlar remove methodunu kendileri yazacak. 
	*/
}
