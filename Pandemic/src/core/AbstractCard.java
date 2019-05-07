package core;

public abstract class AbstractCard {
	private String name;

	public AbstractCard(String name) {
		setName(name);
	}
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
}
