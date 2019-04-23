package core;
import java.util.List;

/*
 * This class is necessary because we might use it to extend this class for other Pandemic Types.
 */

public class AbstractHandDeck extends AbstractDeck { 

	public AbstractHandDeck(List<AbstractCard> deck) {
		super(deck);
	}
	
	public AbstractCard removeCardFromDeck(AbstractCard c) {
		this.getDeck().remove(c);
		return c;
	}
	
}
