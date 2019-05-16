package PandemicKids;

import java.util.ArrayList;
import java.util.List;

import core.AbstractBoardNode;
import core.AbstractGameConfiguration;
import core.Color;
import pandemicBase.BoardNode;

public class PandemicKidsGameConfiguration extends AbstractGameConfiguration {

	@Override
	public int getNumberOfDiseaseCubeTypes() {
		return 3;
	}

	@Override
	public int getNumberOfDiseaseCubePerCubeType() {
		return 20;
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
		return 3;
	}

	@Override
	public int[] getValuesOfInfectionRateNumber() {
		int[] values = new int[]{1,2,2,2,3,3,3};
		return values;

	}

	@Override
	public int getNumberOfNodes() {
		return 10;
	}

	@Override
	public String getInitialBoardNode() {
		return "Iyte";
	}

	@Override
	public List<AbstractBoardNode> getNodes() {
		List<AbstractBoardNode> nodeList = new ArrayList<AbstractBoardNode>();
		AbstractBoardNode nodeIyte = new BoardNode("Iyte",Color.YELLOW,1);
		AbstractBoardNode nodeRivendell = new BoardNode("Rivendell",Color.YELLOW,2);
		AbstractBoardNode nodeNeverland = new BoardNode("Neverland",Color.YELLOW,3);
		nodeList.add(nodeIyte);
		nodeList.add(nodeRivendell);
		nodeList.add(nodeNeverland);
		
		AbstractBoardNode nodeWonderland = new BoardNode("Wonderland",Color.RED,4);
		AbstractBoardNode nodeHogwarst = new BoardNode("Hogwarst",Color.RED,5);
		AbstractBoardNode nodeNarnia = new BoardNode("Narnia",Color.RED,6);
		AbstractBoardNode nodeWesteros = new BoardNode("Westeros",Color.RED,7);
		nodeList.add(nodeWonderland);
		nodeList.add(nodeHogwarst);
		nodeList.add(nodeNarnia);
		nodeList.add(nodeWesteros);
		
		AbstractBoardNode nodeKeystone = new BoardNode("Keystone",Color.BLUE,8);
		AbstractBoardNode nodeEarth = new BoardNode("Earth",Color.BLUE,9);
		AbstractBoardNode nodeOlympus = new BoardNode("Olympus",Color.BLUE,10);
		nodeList.add(nodeKeystone);
		nodeList.add(nodeEarth);
		nodeList.add(nodeOlympus);
		
		
		//The neighbors
		nodeIyte.addNeighbor(nodeWonderland);
		nodeIyte.addNeighbor(nodeOlympus);
		
		nodeWonderland.addNeighbor(nodeIyte);
		nodeWonderland.addNeighbor(nodeKeystone);
		
		nodeOlympus.addNeighbor(nodeIyte);
		nodeOlympus.addNeighbor(nodeRivendell);
		nodeOlympus.addNeighbor(nodeHogwarst);
		
		nodeRivendell.addNeighbor(nodeOlympus);
		nodeRivendell.addNeighbor(nodeKeystone);
		
		nodeKeystone.addNeighbor(nodeRivendell);
		nodeKeystone.addNeighbor(nodeWonderland);
		nodeKeystone.addNeighbor(nodeWesteros);
		
		nodeHogwarst.addNeighbor(nodeOlympus);
		nodeHogwarst.addNeighbor(nodeEarth);
		nodeHogwarst.addNeighbor(nodeNarnia);
		
		nodeEarth.addNeighbor(nodeHogwarst);
		nodeEarth.addNeighbor(nodeWesteros);
		
		nodeWesteros.addNeighbor(nodeKeystone);
		nodeWesteros.addNeighbor(nodeEarth);
		nodeWesteros.addNeighbor(nodeNeverland);
		
		nodeNarnia.addNeighbor(nodeHogwarst);
		nodeNarnia.addNeighbor(nodeNeverland);
		
		nodeNeverland.addNeighbor(nodeWesteros);
		nodeNeverland.addNeighbor(nodeNarnia);

		return nodeList;
	}

	@Override
	public List<String> getNameOfRoles() {
		List<String> roleList = new ArrayList<String>();
		roleList.add("Aslan");
		roleList.add("Demigod");
		roleList.add("Wizard");
		return roleList;
	}

}
