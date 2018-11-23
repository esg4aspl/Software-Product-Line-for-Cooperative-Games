package Component;

import java.util.ArrayList;

public class Player {
	private int ID;
	private Pawn pawn;
	private ArrayList<GamePieces> gamePieces = new ArrayList<GamePieces>(); 
	
	public Player(int id) {
		setID(id);
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

	public ArrayList<GamePieces> getGamePieces() {
		return gamePieces;
	}


}
