package core;


import core.AbstractCard;
import pandemicBase.Board;
import pandemicBase.Player;

public interface IMoveValidation {
	void evaluate(AbstractCard card,Board board,Player player);
}
