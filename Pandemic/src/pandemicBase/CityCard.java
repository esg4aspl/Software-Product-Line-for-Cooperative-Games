package pandemicBase;

import core.AbstractCard;

public class CityCard extends AbstractCard {
	int population;
	
	public CityCard(String name,int population) {
		super(name);
		setPopulation(population);
	}
	
	public int getPopulation() {
		return population;
	}
	
	private void setPopulation(int population) {
		this.population = population;
	}
}
