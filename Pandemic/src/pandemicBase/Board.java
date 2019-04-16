package pandemicBase;

import java.util.ArrayList;

import core.AbstractBoard;

public class Board extends AbstractBoard{
	private ArrayList<BoardNode> nodeList;
	
	public Board(ArrayList<BoardNode> nodeList) {
		setNodeList(nodeList);
	}
	public ArrayList<BoardNode> getNodeList() {
		return nodeList;
	}
	public void setNodeList(ArrayList<BoardNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	
}
