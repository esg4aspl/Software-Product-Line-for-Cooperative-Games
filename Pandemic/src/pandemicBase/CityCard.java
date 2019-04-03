package pandemicBase;

import core.AbstractCard;

public class CityCard extends AbstractCard {
	private String cityName;

	public CityCard(String name) {
		setCityName(name);
	}
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

}
