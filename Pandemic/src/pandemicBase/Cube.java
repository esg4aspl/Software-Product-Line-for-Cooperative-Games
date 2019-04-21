package pandemicBase;

import core.AbstractGamePiece;
import core.Color;

public class Cube extends AbstractGamePiece {
	private static int id = 0;
	private Color color;

	public Cube(Color color) {
		super(id);
		this.color = color;
		id++;
	}
	public Color getColor() {
		return color;
	}
}
