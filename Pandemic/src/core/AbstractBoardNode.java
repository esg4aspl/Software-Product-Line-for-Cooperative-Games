package core;

import java.util.Set;

public abstract class AbstractBoardNode {
	protected String name;
	public AbstractBoardNode(String name) {
		setName(name);
	}
	public abstract Set<AbstractBoardNode> getNeighborList();
	public abstract void addNeighbor(AbstractBoardNode node);
	public abstract boolean isNeighbor(AbstractBoardNode boardNode);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
