package pandemicBase;

import core.AbstractBoardNode;
import core.AbstractDeck;
import core.AbstractPlayer;
import core.AbstractRole;

public class Player extends AbstractPlayer{	
	public Player(AbstractDeck deck,AbstractRole role, int id,
			 AbstractBoardNode currentNode) {
		super(deck,role,id,currentNode);
	}
}
