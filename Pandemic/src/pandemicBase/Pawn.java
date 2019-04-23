package pandemicBase;

import core.AbstractGamePiece;
import core.Color;

public class Pawn extends AbstractGamePiece {
	Color color;
	public Pawn(int ID,Color color) {
		super(ID);
		setColor(color);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

}
