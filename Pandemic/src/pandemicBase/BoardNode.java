package pandemicBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import core.AbstractBoardNode;
import core.AbstractGamePieces;
import core.Color;

public class BoardNode extends AbstractBoardNode{

	private String name;
	private Color color;
	private int population;
	private Set<AbstractBoardNode> neighborList  = new HashSet<AbstractBoardNode>();
	private ArrayList<AbstractGamePieces> piecesOnTheNode = new ArrayList<AbstractGamePieces>();
	public BoardNode(String name,Color color, int population) {
		setColor(color);
		setName(name);
		setPopulation(population);
		//setNeighborList(neighborList);
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<AbstractBoardNode> getNeighborList() {
		return neighborList;
	}
	public void setNeighborList(Set<AbstractBoardNode> neighborList) {
		this.neighborList = neighborList;
	}
	
	public void addPieceOnTheNode(AbstractGamePieces piece) {
		piecesOnTheNode.add(piece);
	}
	public void removePieceOnTheNode(AbstractGamePieces piece) {
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
	
}
