package rules;

import core.AbstractCard;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.EpidemicCard;

public class RuleIsCurrentPlayerDrawnCardNotEpidemicCard implements IRule{

	public RuleIsCurrentPlayerDrawnCardNotEpidemicCard() {	
	}
	
	@Override
	public boolean evaluate(AbstractReferee referee) {
		//�ekilen kart epidemic mi de�il mi bunun kontrol� yap�l�r. 
		AbstractCard card = referee.getCurrentPlayerDrawnCard();
		if(card instanceof EpidemicCard) {
			return false;
		}
		
		return true;
	}

}
