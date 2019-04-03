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
		//Çekilen kart epidemic mi deðil mi bunun kontrolü yapýlýr. 
		AbstractCard card = referee.getCurrentPlayerDrawnCard();
		if(card instanceof EpidemicCard) {
			return false;
		}
		
		return true;
	}

}
