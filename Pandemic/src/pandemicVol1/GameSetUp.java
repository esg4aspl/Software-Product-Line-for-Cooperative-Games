package pandemicVol1;

import java.util.ArrayList;

import core.AbstractCard;
import core.AbstractGamePieces;
import pandemicBase.Board;
import pandemicBase.BoardNode;
import pandemicBase.CityCard;
import pandemicBase.Figure;
import pandemicBase.Player;
import pandemicBase.RoleCard;
import rules.DriveMove;
import core.IMoveValidation;
import rules.Scientist;

public class GameSetUp {

	public static void main(String[] args) {
		 //hadi bir board olu�tural�m bakal�mm
		
		BoardNode Chicago = new BoardNode("chicago");//ilk node olu�turuldu�unda kom�ucuklar� yok.
		BoardNode Toronto = new BoardNode("toronto");
		BoardNode Newyork = new BoardNode("newyork");
		BoardNode Atlanta = new BoardNode("atlanta");
		BoardNode WashigtonDC = new BoardNode("washigtonDC");
		BoardNode Miami = new BoardNode("miami");
		
		Chicago.addNeigbor(Toronto);
		Chicago.addNeigbor(Atlanta);
		Toronto.addNeigbor(Chicago);
		Toronto.addNeigbor(Newyork);
		Toronto.addNeigbor(WashigtonDC);
		Newyork.addNeigbor(Toronto);
		Newyork.addNeigbor(WashigtonDC);
		Atlanta.addNeigbor(Chicago);
		Atlanta.addNeigbor(WashigtonDC);
		Atlanta.addNeigbor(Miami);
		WashigtonDC.addNeigbor(Newyork);
		WashigtonDC.addNeigbor(Toronto);
		WashigtonDC.addNeigbor(Atlanta);
		WashigtonDC.addNeigbor(Miami);
		Miami.addNeigbor(Atlanta);
		Miami.addNeigbor(WashigtonDC);
		
		//�imdi de board olu�tural�m.
		 ArrayList<BoardNode> cityList = new ArrayList<BoardNode> ();
		 cityList.add(Newyork);
		 cityList.add(Miami);
		 cityList.add(WashigtonDC);
		 cityList.add(Atlanta);
		 cityList.add(Toronto);
		 cityList.add(Chicago);
		 
		 Board board = new Board(cityList);
		 
		 //iki tane de player olu�tural�m
		 
		 Player player1 = new Player(1, Atlanta); //ba�lang�� node'u atlanta Player atlanta'da oldu�unu biliyor ama node player'i bilmiyor.Eklemeli miyiz?
		 Player player2 = new Player(2, Atlanta); //ba�lang�� node'u atlanta
		 
		 //Atlanta'ya bir research station kural�m.
		 AbstractGamePieces resarchStation1 = new Figure(3);
		 
		 Atlanta.addPieceOnTheNode(resarchStation1);
		 
		//iki rol kart olu�tural�m 
		 
		 AbstractCard scientist1 = new Scientist();
		 player1.addCard(scientist1);
		 AbstractCard scientist2 = new Scientist();
		 player2.addCard(scientist2);
		
		 //iki city card verelim
		 AbstractCard MiamiCard = new CityCard("miami card");
		 player1.addCard(MiamiCard);
		 AbstractCard AtlantaCard = new CityCard("atlanta card");
		 player2.addCard(AtlantaCard);
		 
		 int endCondition = 2; //end condtion belirlendikten sonra while true i�ine al�nmal�
		 while(endCondition!=0) {
			 IMoveValidation driveMove = new DriveMove();
			 driveMove.evaluate(null, board, player1); //card arg�man� i�in null verdim ??,drive move hamlesi card gerektirmiyor.
			 driveMove.evaluate(null, board, player2);
			 endCondition--;
		 }
		 
		

	}
	
	//private ArrayList<BoardNode> nodeList = new ArrayList<BoardNode> ();
	/***
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
	public ArrayList<BoardNode> getNodeList() {
		return nodeList;
	}
	
***/
}