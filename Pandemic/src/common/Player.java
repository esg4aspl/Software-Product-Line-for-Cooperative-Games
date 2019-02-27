package common;
import java.util.ArrayList;

public class Player {
	private int ID;
	private Pawn pawn;
	private ArrayList<AbstractGamePieces> gamePieces = new ArrayList<AbstractGamePieces>(); //?
	private BoardNode currentNode;
	public Player(int id,BoardNode currentNode) {
		setID(id);
		setCurrentNode(currentNode);
	}

	public int getID() {
		return ID;
	}

	private void setID(int iD) {
		this.ID = iD;
	}

	public Pawn getPawn() {
		return pawn;
	}

	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}

	public ArrayList<AbstractGamePieces> getGamePieces() {
		return gamePieces;
	}

	public BoardNode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(BoardNode currentNode) {
		this.currentNode = currentNode;
	}
	

}
