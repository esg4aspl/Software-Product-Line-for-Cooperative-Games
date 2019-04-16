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
		//Çekilen kart epidemic mi deðil mi bunun kontrolü yapýlýr. 
		AbstractCard card = referee.getCurrentPlayerDrawnCard();
		if(card instanceof EpidemicCard) {
			return false;
		}
		
		return true;
	}

}
