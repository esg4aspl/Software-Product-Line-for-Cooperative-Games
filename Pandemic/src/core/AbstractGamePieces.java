package core;
public abstract class AbstractGamePieces {
	private int ID;
	private AbstractBoardNode currentNode;
	public AbstractGamePieces(int id) {
		setID(id);
	}
	public AbstractGamePieces() {
		
	}
	private void setID(int id) {
		this.ID = id;
	}
	public int getID() {
		return this.ID;
	}
	public AbstractBoardNode getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(AbstractBoardNode currentNode) {
		this.currentNode = currentNode;
	}
}
