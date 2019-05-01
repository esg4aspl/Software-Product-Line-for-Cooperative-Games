package rules;

import core.AbstractReferee;
import core.IRule;

public class RuleNoConstriantNeeded implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		return true;
	}

}
