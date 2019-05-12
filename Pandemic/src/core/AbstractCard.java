package core;

public abstract class AbstractCard {
	private String name;
	private int id;

	public AbstractCard(String name,int id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}
	public String toString() {
		return "CardID: " + id + " CardName:" + name;
	}
}
