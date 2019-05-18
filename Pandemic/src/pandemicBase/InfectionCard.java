package pandemicBase;

import core.AbstractCard;
import core.Color;

public class InfectionCard extends AbstractCard {
	Color color;
	public InfectionCard(String name,Color color) {
		super(name,0);
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
}
