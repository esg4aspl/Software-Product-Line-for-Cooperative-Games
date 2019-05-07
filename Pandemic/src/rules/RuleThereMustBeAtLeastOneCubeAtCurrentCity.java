package rules;

import java.util.List;

import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.IRule;
import pandemicBase.BoardNode;
import pandemicBase.Cube;

public class RuleThereMustBeAtLeastOneCubeAtCurrentCity implements IRule {
	private Color diseaseColor;
	public RuleThereMustBeAtLeastOneCubeAtCurrentCity(Color diseaseColor) {
		this.diseaseColor = diseaseColor;
	}

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = currentPlayer.getCurrentNode();
		List<AbstractGamePiece> piecesOnTheCurrentNode = ((BoardNode)currentNode).getPiecesOnNode();
		for(AbstractGamePiece gamePiece : piecesOnTheCurrentNode ) {
			if(gamePiece instanceof Cube && ((Cube)gamePiece).getColor().equals(diseaseColor)) {
				return true;
			}
		}
		return false;
	}

}
