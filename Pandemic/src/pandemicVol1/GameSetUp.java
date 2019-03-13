package pandemicVol1;

import java.util.ArrayList;

import common.Board;
import common.BoardNode;

public class GameSetUp {

	public static void main(String[] args) {
		

	}
	
	private ArrayList<BoardNode> nodeList = new ArrayList<BoardNode> ();
	
	public BoardNode createCityNode(String name,ArrayList<BoardNode> neighborList) {
		//arg�manlar� guiden alaca��z.her girilen node i�in tekrar �a�r�lmas� laz�m bu arkada��n.
		BoardNode node = new BoardNode(name,neighborList);
		nodeList.add(node);
		return node;
		
	}
	
	public Board  createBoard(int numberOfNodes) {
		Board board = new Board(nodeList);
		return board;
		
	}

}