package pandemicBase;

import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractDeck;
import core.AbstractPlayer;
import core.AbstractRole;
import core.Color;

public class Player extends AbstractPlayer{	
	public Player(AbstractDeck deck,AbstractRole role, int id,
			 AbstractBoardNode currentNode) {
		super(deck,role,id,currentNode);
	}
	public void discardCard(Color color ,int numOfCardsOfSameColor){
		for (AbstractCard card : getHand().getDeck()) {
			if(((CityCard)card).getColor().equals(color)) {
				discardCard(card);
				numOfCardsOfSameColor--;
				if(numOfCardsOfSameColor == 0) {
					break;
				}
			}
			
		}			
	}
	@Override
	protected void setOrder() {
		int maxPopulation = 0;
		for (AbstractCard card : getHand().getDeck()) {
			if(maxPopulation < ((CityCard)card).getPopulation()) {
				maxPopulation = ((CityCard)card).getPopulation();
			}
		
		}
		this.order = maxPopulation;
	}
	
}
