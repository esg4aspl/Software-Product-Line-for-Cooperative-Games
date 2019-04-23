package core;
import java.util.*;

/* 
 * Hand, player and infection decks have different signature for remove method.  
 * That's why the classes which extend this class will write their own method.
*/

public abstract class AbstractDeck {
	private List<AbstractCard> deck;
	public AbstractDeck(List<AbstractCard> deck) {
		createDeck(deck);
	}
	protected List<AbstractCard> getDeck() {
		return deck;
	}
	private void createDeck(List<AbstractCard> deck) {
		this.deck = deck;
	}
	public void addCardToDeck(AbstractCard c) {
		this.deck.add(c);
	}
	public void shuffle() {
        Collections.shuffle(deck);
	}
	public int size() {
		return deck.size();
	}
	
	public boolean doesHave(String cardName) {
		for ( AbstractCard cardInDeck : this.getDeck() ) {
			if(cardInDeck.getName().equals(cardName)) {
				return true;
			}
		}
		return false;
	}
	
}
