package constraints;

import core.AbstractCard;
import core.AbstractReferee;
import core.IConstraint;
import pandemicBase.EpidemicCard;

public class ConstraintIsCurrentPlayerDrawnCardNotEpidemicCard implements IConstraint{

	public ConstraintIsCurrentPlayerDrawnCardNotEpidemicCard() {	
	}
	
	@Override
	public boolean check(AbstractReferee referee) {
		//�ekilen kart epidemic mi de�il mi bunun kontrol� yap�l�r. 
		AbstractCard card = referee.getCurrentPlayerDrawnCard();
		if(card instanceof EpidemicCard) {
			return false;
		}
		
		return true;
	}

}
