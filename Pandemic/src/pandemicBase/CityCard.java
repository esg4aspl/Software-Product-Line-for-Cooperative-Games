package pandemicBase;

import core.AbstractCard;
import core.Color;

public class CityCard extends AbstractCard {
	private int population;
	private Color color;
	private static int idCounter=1;
	
	public CityCard(String name,int population,Color color) {
		super(name,idCounter);
		this.population = population;
		this.color = color;
		idCounter++;
	}
	
	public int getPopulation() {
		return population;
	}

	public Color getColor() {
		return color;
	}
	
}
