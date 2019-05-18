package rules;

import core.AbstractBoardNode;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.BoardNode;

public class RuleThereMustBeNoCubeOfSameColorOnNodeForEpidemic implements IRule {
	AbstractBoardNode boardNode;
	public RuleThereMustBeNoCubeOfSameColorOnNodeForEpidemic(AbstractBoardNode boardNode) {
		this.boardNode = boardNode;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		if(((BoardNode)boardNode).howManyCubesDoesHave(((BoardNode)boardNode).getColor()) == 0) {
			return true;
		}
		return false;
	}

}
