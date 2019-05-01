package rules;

import java.util.List;

import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.BoardNode;
import pandemicBase.Cube;

public class RuleThereMustBeAtLeastOneCubeAtCurrentCity implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		List<AbstractGamePiece> piecesOnTheCurrentNode = ((BoardNode)currentNode).getPiecesOnTheNode();
		for(AbstractGamePiece gamePiece : piecesOnTheCurrentNode ) {
			if(gamePiece instanceof Cube) {
				return true;
			}
		}
		return false;
	}

}
