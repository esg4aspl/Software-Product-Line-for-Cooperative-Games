package rules;

import core.AbstractBoardNode;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.BoardNode;

public class RuleThereMustBeLessThanThreeCubesOfSameColorOnNode implements IRule {
	AbstractBoardNode boardNode;
	public RuleThereMustBeLessThanThreeCubesOfSameColorOnNode(AbstractBoardNode boardNode) {
		this.boardNode = boardNode;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		if(((BoardNode)boardNode).howManyCubesDoesHave(((BoardNode)boardNode).getColor()) < 3) {
			return true;
		}
		return false;
	}

}
