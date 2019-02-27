package common;

import java.util.ArrayList;

public class Board {
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
