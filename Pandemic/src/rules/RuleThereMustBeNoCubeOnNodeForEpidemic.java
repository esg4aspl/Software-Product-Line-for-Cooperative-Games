package rules;

import core.AbstractBoardNode;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.BoardNode;

public class RuleThereMustBeNoCubeOnNodeForEpidemic implements IRule {
	AbstractBoardNode boardNode;
	public RuleThereMustBeNoCubeOnNodeForEpidemic(AbstractBoardNode boardNode) {
		this.boardNode = boardNode;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		if(((BoardNode)boardNode).howManyCubesDoesHave() == 0) {
			return true;
		}
		return false;
	}

}
