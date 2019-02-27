package common;
public abstract class AbstractGamePieces {
	private int ID;
	public AbstractGamePieces(int id) {
		setID(id);
	}
	public AbstractGamePieces() {
		
	}
	private void setID(int id) {
		this.ID = id;
	}
	public int getID() {
		return this.ID;
	}
}
