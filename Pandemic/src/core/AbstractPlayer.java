package core;

import pandemicBase.PlayerDeck;

public abstract class AbstractPlayer {
	private Color color;
	private AbstractRole role;
	private AbstractDeck deck;
	private AbstractGamePieces pawn;
	
	public AbstractPlayer(AbstractDeck deck,AbstractRole role, Color color,AbstractGamePieces pawn) {
		setDeck(deck);
		setRole(role);
		setColor(color);
		setPawn(pawn);
	}
	
	public AbstractGamePieces getPawn() {
		return pawn;
	}

	public void setPawn(AbstractGamePieces pawn) {
		this.pawn = pawn;
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
	public AbstractCard drawCard(AbstractStackDeck deck) { // Ba�ka bir listeden kart �ekme...
		return deck.drawTheCardOnTopFromTheDeck();
	}
	public void addCardToTheDeck(AbstractCard c) { // Kendi listesine kart ekleme...
		this.deck.addCardToTheDeck(c);
	}
	public AbstractCard discardCard(AbstractCard c) { // Ba�ka bir listeden kart �ekme...
		return ((PlayerDeck)deck).removeTheCardFromTheDeck(c); // Abstract Deck iki tip mi olsun? Base'den core'a import yapmak mant�kl� m�?
	}
}
