package pandemicBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.Color;

public class BoardNode extends AbstractBoardNode{

	
	private Color color;
	private int population;
	private Set<AbstractBoardNode> neighborList  = new HashSet<AbstractBoardNode>();
	private ArrayList<AbstractGamePiece> piecesOnTheNode = new ArrayList<AbstractGamePiece>();
	public BoardNode(String name,Color color, int population) {
		super(name);
		setColor(color);
		setPopulation(population);
		//setNeighborList(neighborList);
		}
	
	
	public Set<AbstractBoardNode> getNeighborList() {
		return neighborList;
	}
	public void setNeighborList(Set<AbstractBoardNode> neighborList) {
		this.neighborList = neighborList;
	}
	
	public void addPieceOnTheNode(AbstractGamePiece piece) {
		piecesOnTheNode.add(piece);
	}
	public void removePieceOnTheNode(AbstractGamePiece piece) {
		piecesOnTheNode.remove(piece);
	}
	
	public void addNeighbor(AbstractBoardNode node) {
		neighborList.add(node);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	public boolean isNeighbor(AbstractBoardNode boardNode) {
		for (AbstractBoardNode boardNodeInList : neighborList) {
			if(boardNodeInList.equals(boardNode)) {
				return true;
			}
		}
		return false;
	}


	public ArrayList<AbstractGamePiece> getPiecesOnTheNode() {
		
		return piecesOnTheNode;
	}
	
}
