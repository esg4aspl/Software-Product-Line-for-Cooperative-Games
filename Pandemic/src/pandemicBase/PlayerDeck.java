package pandemicBase;

import java.util.List;

import core.AbstractCard;
import core.AbstractDeck;

public class PlayerDeck extends AbstractDeck {

	public PlayerDeck(List<AbstractCard> deck) {
		super(deck);
	}
	public AbstractCard removeTheCardFromTheDeck(AbstractCard c) {
		this.getDeck().remove(c);
		return c;
	}

}
