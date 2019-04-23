package pandemicBase;

import java.util.ArrayList;

import core.AbstractCard;
import core.AbstractDeck;

public class PlayerDiscardPile extends AbstractDeck {
	public PlayerDiscardPile() {
		super(new ArrayList<AbstractCard>());
	}
}
