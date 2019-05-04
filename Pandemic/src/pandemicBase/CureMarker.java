package pandemicBase;

import core.AbstractGamePiece;
import core.Color;

public class CureMarker extends AbstractGamePiece {
	private boolean isEradicated;
	private boolean isCured;
	private Color color;
	public CureMarker(Color color) {
		this.isEradicated = false;
		this.isCured = false;
		this.color = color;


	}
	public boolean isEradicated() {
		return isEradicated;
	}
	public void eradicateDisease() {
		this.isEradicated = true;
	}
	public boolean isCured() {
		return isCured;
	}
	public void cureDisease() {
		this.isCured = true;
	}
	public Color getColor() {
		return color;
	}
}
