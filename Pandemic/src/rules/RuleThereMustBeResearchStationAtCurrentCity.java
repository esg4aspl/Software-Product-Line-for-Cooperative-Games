package rules;

import java.util.ArrayList;

import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.BoardNode;
import pandemicBase.ResearchStation;

public class RuleThereMustBeResearchStationAtCurrentCity implements IRule {

	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractPlayer player = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = player.getCurrentNode();
		ArrayList<AbstractGamePiece> piecesOnTheCurrentNode =  ((BoardNode) currentNode).getPiecesOnTheNode() ;
		for(AbstractGamePiece gamePiece : piecesOnTheCurrentNode ) {	
			if(gamePiece instanceof ResearchStation ) {
				return true;
			}
		}
			
		return false;
	}

}
