package pandemicBase;

import java.util.List;

import core.AbstractCard;
import core.AbstractStackDeck;

public class InfectionDeck extends AbstractStackDeck {

	public InfectionDeck(List<AbstractCard> deck) {
		super(deck);
	}
	public AbstractCard drawBottomCardFromDeck() {
		return deck.get(0);
	}
	public void addInfectionDiscardPile(InfectionDiscardPile infectionDeck) {
		for (AbstractCard cardFromDiscardPile : infectionDeck.getDeck()) {
			deck.add(cardFromDiscardPile);
		}
	}

}
