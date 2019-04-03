package core;

import pandemicBase.PlayerDeck;

public abstract class AbstractPlayer {
	private Color color;
	private AbstractRole role;
	private AbstractDeck deck;
	
	public AbstractPlayer(AbstractDeck deck,AbstractRole role, Color color) {
		setDeck(deck);
		setRole(role);
		setColor(color);
		
	}
	protected AbstractDeck getDeck() {
		return deck;
	}
	private void setDeck(AbstractDeck deck) {
		this.deck = deck;
	}
	public Color getColor() {
		return color;
	}
	protected void setColor(Color color) {
		this.color = color;
	}
	public AbstractRole getRole() {
		return role;
	}
	protected void setRole(AbstractRole role) {
		this.role = role;
	}
	public AbstractCard drawCard(AbstractStackDeck deck) { // Baþka bir listeden kart çekme...
		return deck.drawTheCardOnTopFromTheDeck();
	}
	public void addCardToTheDeck(AbstractCard c) { // Kendi listesine kart ekleme...
		this.deck.addCardToTheDeck(c);
	}
	public AbstractCard discardCard(AbstractCard c) { // Baþka bir listeden kart çekme...
		return ((PlayerDeck)deck).removeTheCardFromTheDeck(c); // Abstract Deck iki tip mi olsun? Base'den core'a import yapmak mantýklý mý?
	}
}
