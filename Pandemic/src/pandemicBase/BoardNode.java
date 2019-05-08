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

	private List<AbstractPlayer> playersOnNode;
	private Color color;
	private int population;
	private Set<AbstractBoardNode> neighborList;
	private ArrayList<AbstractGamePiece> piecesOnNode;
	public BoardNode(String name,Color color, int population) {
		super(name);
		
		this.color = color;
		this.population = population;
		neighborList  = new HashSet<AbstractBoardNode>();
		piecesOnNode = new ArrayList<AbstractGamePiece>();
		playersOnNode = new ArrayList<AbstractPlayer>();
	}
	
	
	public Set<AbstractBoardNode> getNeighborList() {
		return neighborList;
	}
	public void setNeighborList(Set<AbstractBoardNode> neighborList) {
		this.neighborList = neighborList;
	}
	
	public void addPieceOnNode(AbstractGamePiece piece) {
		piecesOnNode.add(piece);
	}
	public List<AbstractGamePiece> removeCubesFromNode(Color cubeColor,int numOfCubesToBeRemoved) {
		List<AbstractGamePiece> cubesToBeRemoved = new ArrayList<AbstractGamePiece>();
		for (AbstractGamePiece piece : piecesOnNode) {
			if(piece instanceof Cube && ((Cube)piece).getColor().equals(cubeColor)&& numOfCubesToBeRemoved>0) {
				numOfCubesToBeRemoved--;
				piecesOnNode.remove(piece);
				cubesToBeRemoved.add(piece);
			}
		}
		return cubesToBeRemoved;
	}
	
	public boolean doesHaveSpecificColoredCube(Color cubeColor) {
		for (AbstractGamePiece piece : piecesOnNode) {
			if(piece instanceof Cube && ((Cube)piece).getColor().equals(cubeColor)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean doesHaveResearchStation() {
		for (AbstractGamePiece piece : piecesOnNode) {
			if(piece instanceof ResearchStation) {
				return true;
			}
		}
		return false;
	}
	public int howManyCubesDoesHave(Color cubeColor) {
		int count = 0;
		for(AbstractGamePiece piece: piecesOnNode ) {
			if(piece instanceof Cube &&((Cube)piece).getColor().equals(cubeColor)) {
				count ++;
			}
		}
		return count;
	}
	
	public void addNeighbor(AbstractBoardNode node) {
		neighborList.add(node);
	}

	public Color getColor() {
		return color;
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


	public ArrayList<AbstractGamePiece> getPiecesOnNode() {
		return piecesOnNode;
	}


	public List<AbstractPlayer> getPlayersOnNode() {
		return playersOnNode;
	}


	public void addPlayersOnTheNode(AbstractPlayer player) {
		playersOnNode.add(player);
	}
	
}
