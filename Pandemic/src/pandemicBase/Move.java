package pandemicBase;

import java.util.Scanner;

import core.AbstractMove;

public class Move extends AbstractMove {

	@Override

	public void doAction(Player player,Board board) {
		BoardNode node = getDestinationNode(board, player);
		System.out.println("null");
		if (node != null) {
		player.setCurrentNode(node); //change the player's current location
		//þurada bir de nodelarýn bilgisini deðiþtirmek lazým hem src hem de dst nodelarýn
		System.out.println("Player " + node.getName() + " þehrinde");
		}
		else {
			System.out.println("invalid node");
		}
	}
	
	private BoardNode getDestinationNode(Board board,Player player) { 
		//scaner yazdýk ama guiden almamýz lazým ve drop down menu gibi,kullanýcý elle yazmasýn seçsin.
		Scanner input = new Scanner(System.in);
        System.out.println("Enter Destionation City ");
        String destNodeName = input.nextLine();
        for (BoardNode node : board.getNodeList()){
        	if( node.getName().equals(destNodeName) && player.getCurrentNode().getNeighborList().contains(node)) {//komþu mu deðil mi bakýyor
        		 
        		return node;
        	}
        	
        }
        return null;
	}

}
