package pandemicBase;

import core.AbstractMovementAction;
import core.AbstractPlayer;
import core.AbstractReferee;

public class MoveToAnotherCity extends AbstractMovementAction {

	@Override
	public void doAction(AbstractReferee referee) {
		AbstractMovementAction move = (AbstractMovementAction)referee.getCurrentMove(); //down casting ?
		BoardNode destinationNode = (BoardNode) move.getDestinationBoardNode();
		BoardNode currentNode = (BoardNode) referee.getCurrentNode();
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		currentNode.removePieceOnTheNode(currentPlayer.getPawn());
		destinationNode.addPieceOnTheNode(currentPlayer.getPawn());
		
	}
	

}
