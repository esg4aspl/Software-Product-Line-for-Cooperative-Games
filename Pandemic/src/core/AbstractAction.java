package core;

public abstract class AbstractAction {
	private ActionType type;
	
	public AbstractAction(ActionType type) {
		this.type = type;
	}
	public ActionType getType() {
		return type;
	}
	
	public abstract void takeAction();
}
