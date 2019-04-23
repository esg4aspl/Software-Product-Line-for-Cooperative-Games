package core;

public abstract class AbstractBoardNode {
	private String name;
	public AbstractBoardNode(String name) {
		setName(name);
	}
	public abstract void addNeighbor(AbstractBoardNode node);
	public abstract boolean isNeighbor(AbstractBoardNode boardNode);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
