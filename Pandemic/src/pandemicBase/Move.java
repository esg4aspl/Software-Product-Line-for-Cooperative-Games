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
		//�urada bir de nodelar�n bilgisini de�i�tirmek laz�m hem src hem de dst nodelar�n
		System.out.println("Player " + node.getName() + " �ehrinde");
		}
		else {
			System.out.println("invalid node");
		}
	}
	
	private BoardNode getDestinationNode(Board board,Player player) { 
		//scaner yazd�k ama guiden almam�z laz�m ve drop down menu gibi,kullan�c� elle yazmas�n se�sin.
		Scanner input = new Scanner(System.in);
        System.out.println("Enter Destionation City ");
        String destNodeName = input.nextLine();
        for (BoardNode node : board.getNodeList()){
        	if( node.getName().equals(destNodeName) && player.getCurrentNode().getNeighborList().contains(node)) {//kom�u mu de�il mi bak�yor
        		 
        		return node;
        	}
        	
        }
        return null;
	}

}
