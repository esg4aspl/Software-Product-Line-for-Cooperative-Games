package rules;

import core.AbstractCard;
import core.AbstractMove;
import pandemicBase.Board;
import pandemicBase.Move;
import pandemicBase.Player;
import core.IMoveValidation;

public class DriveMove  implements IMoveValidation{

	@Override
	public void evaluate(AbstractCard card, Board board, Player player) {
		AbstractMove move = new Move();
		move.doAction(player, board);	
	}

}
