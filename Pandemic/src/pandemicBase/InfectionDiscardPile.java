package pandemicBase;

import java.util.ArrayList;
import java.util.Collections;

import core.AbstractCard;
import core.AbstractDeck;

public class InfectionDiscardPile extends AbstractDeck {
	public InfectionDiscardPile() {
		super(new ArrayList<AbstractCard>());
	}
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
}
