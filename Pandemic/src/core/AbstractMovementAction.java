package core;

public abstract class AbstractMovementAction extends AbstractMove {

	private AbstractBoardNode destinationBoardNode;
	public abstract void doAction(AbstractReferee referee);
	
	public AbstractBoardNode getDestinationBoardNode() {
		return  destinationBoardNode;
	}
	public void setDestinationBoardNode(AbstractBoardNode boardNode) {
		this. destinationBoardNode = boardNode;
	}
	

}
