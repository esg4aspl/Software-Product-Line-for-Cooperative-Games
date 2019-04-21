package core;
public abstract class AbstractGamePiece {
	private int ID;
	public AbstractGamePiece(int id) {
		setID(id);
	}
	private void setID(int id) {
		this.ID = id;
	}
	public int getID() {
		return this.ID;
	}

}
