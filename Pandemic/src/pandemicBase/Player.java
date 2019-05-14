package pandemicBase;

import java.util.ArrayList;
import java.util.List;

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
		List<AbstractCard> cardsWillBeDiscarded = new ArrayList<AbstractCard>();
		for (AbstractCard card : getHand().getDeck()) {
			if(((CityCard)card).getColor().equals(color)) {
				cardsWillBeDiscarded.add(card);
				numOfCardsOfSameColor--;
				if(numOfCardsOfSameColor == 0) {
					break;
				}
			}	
		}
		for (AbstractCard card : cardsWillBeDiscarded) {
			discardCard(card);
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
