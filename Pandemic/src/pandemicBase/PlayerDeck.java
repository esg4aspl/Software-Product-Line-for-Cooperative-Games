package pandemicBase;

import java.util.List;
import core.AbstractCard;
import core.AbstractStackDeck;

public class PlayerDeck extends AbstractStackDeck {

	public PlayerDeck(List<AbstractCard> deck) {
		super(deck);
	}
	
	public void insertEpidemicCard(int index, AbstractCard card) {
		getDeck().add(index, card);
	}
}
