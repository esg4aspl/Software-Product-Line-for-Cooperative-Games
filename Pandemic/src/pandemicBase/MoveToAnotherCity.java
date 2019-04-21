package pandemicBase;

import core.AbstractMovementAction;
import core.AbstractPlayer;
import core.AbstractReferee;

public class MoveToAnotherCity extends AbstractMovementAction {

	@Override
	public void doAction(AbstractReferee referee) {
		AbstractMovementAction move = (AbstractMovementAction)referee.getCurrentMove(); 
		BoardNode destinationNode = (BoardNode) move.getDestinationBoardNode();
		AbstractPlayer currentPlayer = referee.getCurrentPlayer();
		currentPlayer.setCurrentNode(destinationNode);
	}
}
