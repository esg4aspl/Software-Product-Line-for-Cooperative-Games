package pandemicBase;

import java.util.ArrayList;

import core.AbstractGamePieces;

public class BoardNode {

	private String name;
	private ArrayList<BoardNode> neighborList  = new ArrayList<BoardNode>();
	private ArrayList<AbstractGamePieces> piecesOnTheNode = new ArrayList<AbstractGamePieces>();
	public BoardNode(String name) {
		setName(name);
		//setNeighborList(neighborList);
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<BoardNode> getNeighborList() {
		return neighborList;
	}
	public void setNeighborList(ArrayList<BoardNode> neighborList) {
		this.neighborList = neighborList;
	}
	
	public void addPieceOnTheNode(AbstractGamePieces piece) {
		piecesOnTheNode.add(piece);
	}
	
	public void addNeigbor(BoardNode node) {
		neighborList.add(node);
	}
	
}
