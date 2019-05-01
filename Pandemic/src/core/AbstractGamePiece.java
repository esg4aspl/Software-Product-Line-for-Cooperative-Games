package core;
public abstract class AbstractGamePiece {
	private static int ID = 0;
	public AbstractGamePiece() {
		ID++;
	}
	
	public int getID() {
		return this.ID;
	}

}
