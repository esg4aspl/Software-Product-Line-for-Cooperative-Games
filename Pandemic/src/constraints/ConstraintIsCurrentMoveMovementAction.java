package constraints;

import core.AbstractMove;
import core.AbstractMovementAction;
import core.AbstractReferee;
import core.IConstraint;

public class ConstraintIsCurrentMoveMovementAction implements IConstraint {

	@Override
	public boolean check(AbstractReferee referee) {
		AbstractMove move = referee.getCurrentMove();
		if(move instanceof AbstractMovementAction) {
			return true;
		}
		return false;
	}

}
