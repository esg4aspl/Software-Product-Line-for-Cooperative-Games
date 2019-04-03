package core;

public abstract class AbstractRole {
	private Color color;
	protected Color getColor() {
		return color;
	}
	protected void setColor(Color color) {
		this.color = color;
	}
	public abstract void doSpecialMove();
}
