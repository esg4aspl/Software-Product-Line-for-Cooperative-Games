package rules;

import common.AbstractCard;
import common.Board;
import common.Player;

public interface IMoveValidation {
	void evaluate(AbstractCard card,Board board,Player player);
}
