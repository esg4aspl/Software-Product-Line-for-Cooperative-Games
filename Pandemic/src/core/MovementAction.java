package core;

public class MovementAction extends AbstractAction {
	
	private AbstractBoardNode destinationNode;
	private AbstractPlayer player;
	public MovementAction(ActionType type,AbstractPlayer player ,AbstractBoardNode destinationNode) {
		super(type);
		this.destinationNode = destinationNode;
		this.player = player;
	}
	public ActionType getActionType() {
		return getType();
	}
	
	public AbstractBoardNode getDestinationNode() {
		return destinationNode;
	}
	public AbstractPlayer getPlayer() {
		return player;
	}
	public String toString() {
		return getType().toString();
	}
	@Override
	public void takeAction() {
		player.setCurrentNode(destinationNode);
	}

}
