package pandemicVol1;

import java.util.ArrayList;
import java.util.List;

import core.AbstractBoardNode;
import core.AbstractGameConfiguration;
import core.Color;
import pandemicBase.BoardNode;

public class PandemicOriginalGameConfiguration extends AbstractGameConfiguration {

	@Override
	public int getNumberOfDiseaseCubeTypes() {
		return 4;
	}

	@Override
	public int getNumberOfDiseaseCubePerCubeType() {
		return 10;
	}

	@Override
	public int getOutbreakRange() {
		return 5;
	}

	@Override
	public int getNumberOfPlayers() {
		return 2;
	}

	@Override
	public int getNumberOfCardsPerPlayer() {
		return 4;
	}

	@Override
	public int[] getValuesOfInfectionRateNumber() {
		int[] values = new int[]{2,2,2,3,3,4,4};
		return values;
	}

	@Override
	public int getNumberOfNodes() {
		return 20;
	}

	@Override
	public String getInitialBoardNode() {
		return "A";
	}

	@Override
	public List<AbstractBoardNode> getNodes() {
		List<AbstractBoardNode> nodeList = new ArrayList<AbstractBoardNode>();
		AbstractBoardNode nodeA = new BoardNode("A",Color.BLACK,1);
		AbstractBoardNode nodeB = new BoardNode("B",Color.BLACK,2);
		AbstractBoardNode nodeF = new BoardNode("F",Color.BLACK,3);
		AbstractBoardNode nodeK = new BoardNode("K",Color.BLACK,4);
		AbstractBoardNode nodeL = new BoardNode("L",Color.BLACK,5);
		nodeList.add(nodeA);
		nodeList.add(nodeB);
		nodeList.add(nodeF);
		nodeList.add(nodeK);
		nodeList.add(nodeL);
		
		AbstractBoardNode nodeC = new BoardNode("C",Color.YELLOW,6);
		AbstractBoardNode nodeD = new BoardNode("D",Color.YELLOW,7);
		AbstractBoardNode nodeG = new BoardNode("G",Color.YELLOW,8);
		AbstractBoardNode nodeM = new BoardNode("M",Color.YELLOW,9);
		AbstractBoardNode nodeO = new BoardNode("O",Color.YELLOW,10);
		nodeList.add(nodeC);
		nodeList.add(nodeD);
		nodeList.add(nodeG);
		nodeList.add(nodeM);
		nodeList.add(nodeO);
		
		AbstractBoardNode nodeE = new BoardNode("E",Color.BLUE,11);
		AbstractBoardNode nodeH = new BoardNode("H",Color.BLUE,12);
		AbstractBoardNode nodeJ = new BoardNode("J",Color.BLUE,13);
		AbstractBoardNode nodeN = new BoardNode("N",Color.BLUE,14);
		AbstractBoardNode nodeP = new BoardNode("P",Color.BLUE,15);
		nodeList.add(nodeE);
		nodeList.add(nodeH);
		nodeList.add(nodeJ);
		nodeList.add(nodeN);
		nodeList.add(nodeP);
		
		AbstractBoardNode nodeQ = new BoardNode("Q",Color.RED,16);
		AbstractBoardNode nodeR = new BoardNode("R",Color.RED,17);
		AbstractBoardNode nodeS = new BoardNode("S",Color.RED,18);
		AbstractBoardNode nodeT = new BoardNode("T",Color.RED,19);
		AbstractBoardNode nodeU = new BoardNode("U",Color.RED,20);
		nodeList.add(nodeQ);
		nodeList.add(nodeR);
		nodeList.add(nodeS);
		nodeList.add(nodeT);
		nodeList.add(nodeU);
		
		//The neighbors
		nodeA.addNeighbor(nodeB);
		
		nodeB.addNeighbor(nodeA);
		nodeB.addNeighbor(nodeC);
		nodeB.addNeighbor(nodeF);
		
		nodeC.addNeighbor(nodeB);
		nodeC.addNeighbor(nodeD);
		
		nodeD.addNeighbor(nodeC);
		nodeD.addNeighbor(nodeG);
		nodeD.addNeighbor(nodeJ);
		
		nodeE.addNeighbor(nodeF);
		nodeE.addNeighbor(nodeH);
		
		nodeF.addNeighbor(nodeE);
		nodeF.addNeighbor(nodeK);
		nodeF.addNeighbor(nodeL);
		
		nodeL.addNeighbor(nodeF);
		nodeL.addNeighbor(nodeG);
		
		nodeG.addNeighbor(nodeL);
		nodeG.addNeighbor(nodeD);
		nodeG.addNeighbor(nodeM);
		nodeG.addNeighbor(nodeH);
		
		nodeH.addNeighbor(nodeG);
		nodeH.addNeighbor(nodeJ);
		nodeH.addNeighbor(nodeE);
		
		nodeJ.addNeighbor(nodeD);
		nodeJ.addNeighbor(nodeH);
		nodeJ.addNeighbor(nodeN);
		
		nodeK.addNeighbor(nodeF);
		
		nodeM.addNeighbor(nodeG);
		nodeM.addNeighbor(nodeO);
		
		nodeN.addNeighbor(nodeJ);
		nodeN.addNeighbor(nodeP);
		
		nodeO.addNeighbor(nodeM);
		
		nodeP.addNeighbor(nodeQ);
		nodeP.addNeighbor(nodeN);
		nodeP.addNeighbor(nodeS);
		
		nodeQ.addNeighbor(nodeP);
		nodeQ.addNeighbor(nodeT);
		
		nodeR.addNeighbor(nodeU);
		nodeR.addNeighbor(nodeS);
		
		nodeS.addNeighbor(nodeR);
		nodeS.addNeighbor(nodeT);
		nodeS.addNeighbor(nodeU);
		
		nodeT.addNeighbor(nodeS);
		nodeT.addNeighbor(nodeQ);
		nodeT.addNeighbor(nodeU);
		
		nodeU.addNeighbor(nodeR);
		nodeU.addNeighbor(nodeS);
		nodeU.addNeighbor(nodeT);
		
		return nodeList;
	}

	@Override
	public int getNumberOfEpidemicCardsInGame() {
		return 4;
	}

	@Override
	public List<String> getNameOfEventCards() {
		List<String> eventCardList = new ArrayList<String>();
		String eventAirlift = "Airlift";
		eventCardList.add(eventAirlift);
		return eventCardList;
	}

	@Override
	public List<String> getNameOfRoles() {
		List<String> roleList = new ArrayList<String>();
		roleList.add("Medic");
		roleList.add("Researcher");
		return roleList;
	}
}
