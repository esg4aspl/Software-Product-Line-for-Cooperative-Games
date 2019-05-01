package pandemicBase;

import core.AbstractCard;
import core.Color;

public class CityCard extends AbstractCard {
	int population;
	Color color;
	
	public CityCard(String name,int population,Color color) {
		super(name);
		this.population = population;
		this.color = color;
	}
	
	public int getPopulation() {
		return population;
	}

	public Color getColor() {
		return color;
	}
	
}
