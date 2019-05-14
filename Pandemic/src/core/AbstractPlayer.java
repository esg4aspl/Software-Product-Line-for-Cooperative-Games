package core;

public abstract class AbstractPlayer {
	private int ID;
	private AbstractRole role;
	private AbstractDeck hand;
	private AbstractBoardNode currentNode;	
	protected int order;
	
	public AbstractPlayer(AbstractDeck deck,AbstractRole role, int id,
		AbstractBoardNode currentNode) {
		setHand(deck);
		setRole(role);
		setID(id);
		setCurrentNode(currentNode);
		setOrder();
	}
	
	public AbstractDeck getHand() {
		return hand;
	}
	private void setHand(AbstractDeck hand) {
		this.hand = hand;
	}
	
	public int getID() {
		return ID;
	}
	protected void setID(int id) {
		this.ID = id;
	}
	  
	public AbstractRole getRole() {
		return role;
	}
	protected void setRole(AbstractRole role) {
		this.role = role;
	}

	// Player must know where she is because she has to give her location info to referee.
	public AbstractBoardNode getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(AbstractBoardNode currentNode) {
		this.currentNode = currentNode;
	}

	public void addCardToHand(AbstractCard card) { // Add player card to her hand.
		hand.addCardToDeck(card);
	}
	public AbstractCard discardCard(AbstractCard card) { //Discard card from her hand.
		 return((AbstractHandDeck)hand).removeCardFromDeck(card); 
	}
	
	public AbstractCard discardCard(String cardName) { 
		for ( AbstractCard cardInDeck : hand.getDeck() ) {
			if(cardInDeck.getName().equals(cardName)) {
				return ((AbstractHandDeck)hand).removeCardFromDeck(cardInDeck);
			}
		}
		return null;
	}
	public int getOrder() {
		return order;
	}
	protected abstract void setOrder();
	
	
	
	@Override
	public String toString() {
		String handToString = "";
		for (AbstractCard card: hand.getDeck()) {
			handToString = handToString + card +"\n";
		}
		return "Player with role: " + role.getName() 
				+ " is in " + currentNode.getName() + "\n Cards in hand: " + handToString ;
		
	}
	
}
