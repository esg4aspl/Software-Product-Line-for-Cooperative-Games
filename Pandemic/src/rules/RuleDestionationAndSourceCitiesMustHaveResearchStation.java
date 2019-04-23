package rules;

import java.util.ArrayList;

import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import core.MovementAction;
import pandemicBase.BoardNode;
import pandemicBase.ResearchStation;

public class RuleDestionationAndSourceCitiesMustHaveResearchStation implements IRule {
	
	@Override
	public boolean evaluate(AbstractReferee referee) {
		MovementAction currentAction = (MovementAction) referee.getCurrentAction();
		AbstractPlayer player = currentAction.getPlayer();
		AbstractBoardNode currentNode = player.getCurrentNode();
		ArrayList<AbstractGamePiece> piecesOnTheCurrentNode =  ((BoardNode) currentNode).getPiecesOnTheNode() ;
		
		AbstractBoardNode destinationNode = currentAction.getDestinationNode();
		ArrayList<AbstractGamePiece> piecesOnTheDestinationNode =  ((BoardNode) destinationNode).getPiecesOnTheNode() ;
		
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
