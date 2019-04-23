package constraints;

import core.AbstractPlayer;
import core.AbstractReferee;
import core.IConstraint;
import pandemicBaseRoleCards.Medic;

public class ConstraintIsCurrentPlayerMedic implements IConstraint {

	@Override
	public boolean check(AbstractReferee referee) {
		AbstractPlayer player = referee.getCurrentPlayer();
		if(player.getRole()instanceof Medic) {
			return true;
		}
		return false;
	}

}
