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
	public List<AbstractCard> discardCard(Color color ,int numOfCardsOfSameColor){
			
		List<AbstractCard> discardedCardList = new ArrayList<AbstractCard>();
		for (AbstractCard card : getHand().getDeck()) {
			if(((CityCard)card).getColor().equals(color)) {
				discardedCardList.add(discardCard(card));
				numOfCardsOfSameColor--;
				if(numOfCardsOfSameColor == 0) {
					break;
				}
			}
			
		}
		return discardedCardList;
			
	}
}
