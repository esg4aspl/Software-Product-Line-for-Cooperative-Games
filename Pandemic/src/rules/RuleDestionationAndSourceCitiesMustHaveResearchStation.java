package rules;

import java.util.ArrayList;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.ActionShuttleFlight;
import pandemicBase.BoardNode;
import pandemicBase.ResearchStation;

public class RuleDestionationAndSourceCitiesMustHaveResearchStation implements IRule {
	
	@Override
	public boolean evaluate(AbstractReferee referee) {
		AbstractAction currentAction = referee.getCurrentAction();
		AbstractPlayer player = referee.getCurrentPlayer();
		AbstractBoardNode currentNode = player.getCurrentNode();
		ArrayList<AbstractGamePiece> piecesOnTheCurrentNode =  ((BoardNode) currentNode).getPiecesOnNode() ;
		
		AbstractBoardNode destinationNode = ((ActionShuttleFlight) currentAction).getDestinationNode();
		ArrayList<AbstractGamePiece> piecesOnTheDestinationNode =  ((BoardNode) destinationNode).getPiecesOnNode() ;
		
		for(AbstractGamePiece gamePiece : piecesOnTheCurrentNode ) {	
			if(gamePiece instanceof ResearchStation ) {
				for(AbstractGamePiece gamePieceOnDestination : piecesOnTheDestinationNode ) {
					if(gamePieceOnDestination instanceof ResearchStation ) {
						return true;	
					}	
				}
			}
			
		}
		
		return false;
	}

}
