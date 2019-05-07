package rules;

import core.AbstractBoardNode;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.BoardNode;

public class RuleThereMustBeLessThanThreeCubesOnNode implements IRule {
	AbstractBoardNode boardNode;
	public RuleThereMustBeLessThanThreeCubesOnNode(AbstractBoardNode boardNode) {
		this.boardNode = boardNode;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		if(((BoardNode)boardNode).howManyCubesDoesHave() < 3) {
			return true;
		}
		return false;
	}

}
