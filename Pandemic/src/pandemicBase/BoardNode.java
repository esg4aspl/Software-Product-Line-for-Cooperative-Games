package pandemicBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import core.AbstractBoardNode;
import core.AbstractGamePiece;
import core.AbstractPlayer;
import core.Color;

public class BoardNode extends AbstractBoardNode{

	private List<AbstractPlayer> playersOnTheNode;
	private Color color;
	private int population;
	private Set<AbstractBoardNode> neighborList;
	private ArrayList<AbstractGamePiece> piecesOnTheNode;
	public BoardNode(String name,Color color, int population) {
		super(name);
		
		this.color = color;
		this.population = population;
		neighborList  = new HashSet<AbstractBoardNode>();
		piecesOnTheNode = new ArrayList<AbstractGamePiece>();
		playersOnTheNode = new ArrayList<AbstractPlayer>();
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


	public List<AbstractPlayer> getPlayersOnTheNode() {
		return playersOnTheNode;
	}


	public void addPlayersOnTheNode(AbstractPlayer player) {
		playersOnTheNode.add(player);
	}
	
}
