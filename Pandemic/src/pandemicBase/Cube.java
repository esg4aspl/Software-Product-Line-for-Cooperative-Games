package pandemicBase;

import core.AbstractGamePiece;
import core.Color;

public class Cube extends AbstractGamePiece {
	private Color color;

	public Cube(Color color) {
		super();
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
}
