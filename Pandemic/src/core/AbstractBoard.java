package core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBoard {
	protected ArrayList<AbstractBoardNode> nodeList;
	
	public AbstractBoard(List<AbstractBoardNode> nodeList) {
		setNodeList(nodeList);
	}
	public List<AbstractBoardNode> getNodeList() {
		return nodeList;
	}
	private void setNodeList(List<AbstractBoardNode> nodeList) {
		this.nodeList = (ArrayList<AbstractBoardNode>)nodeList;
	}
	public AbstractBoardNode getBoardNode(String name) {
		for (AbstractBoardNode abstractBoardNode : nodeList) {
			if(abstractBoardNode.getName().toUpperCase().equals(name.toUpperCase())) {
				return abstractBoardNode;
			}
		}
		return null;
	}
}
