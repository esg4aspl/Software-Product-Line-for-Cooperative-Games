package Component;

public abstract class GamePieces {
	private int ID;
	public GamePieces(int id) {
		setID(id);
	}
	public GamePieces() {
		
	}
	private void setID(int id) {
		this.ID = id;
	}
	public int getID() {
		return this.ID;
	}
}
