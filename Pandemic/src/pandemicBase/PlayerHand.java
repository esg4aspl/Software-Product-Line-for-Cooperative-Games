package pandemicBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import core.AbstractCard;
import core.AbstractHandDeck;
import core.Color;

public class PlayerHand extends AbstractHandDeck {
	public PlayerHand(List<AbstractCard> deck) {
		super(deck);
	}
	
	private Set<Color> findColorSet(){
		Set<Color> colorSet = new HashSet<Color>();
		for (AbstractCard card : this.getDeck()) {
			colorSet.add(((CityCard)card).getColor());
		}
		return colorSet;
	}
	
	public boolean areThereEnoughCardsOfSameColor(int numOfCardsOfSameColor) {
		Set<Color> colorSet = findColorSet();
		if(colorSet.size() != 0) {
			for (Color color : colorSet) {
				int count = 0;
				for (AbstractCard card : this.getDeck()) {
					if(((CityCard)card).getColor().equals(color)){
						count++;
					}
				}
				if(count >= numOfCardsOfSameColor) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Color getColorOfCardsNeededToFindCure(int numOfCardsOfSameColor) {
		Set<Color> colorSet = findColorSet();
		if(colorSet.size() != 0) {
			for (Color color : colorSet) {
				int count = 0;
				for (AbstractCard card : this.getDeck()) {
					if(((CityCard)card).getColor().equals(color)){
						count++;
					}
				}
				if(count >= numOfCardsOfSameColor) {
					return color;
				}
			}
		}
		return null;
	}
}
