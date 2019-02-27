package pandemicBase;

import common.AbstractCard;
import common.AbstractMove;
import common.Board;
import common.Move;
import common.Player;
import rules.IMoveValidation;

public class DriveMove  implements IMoveValidation{

	@Override
	public void evaluate(AbstractCard card, Board board, Player player) {
		AbstractMove move = new Move();
		move.doAction(player, board);	
	}

}
