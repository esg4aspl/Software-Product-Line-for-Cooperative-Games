package pandemicBase;

import java.util.List;

import core.AbstractAction;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;

public abstract class AbstractActionShareKnowledge extends AbstractAction {
	protected AbstractPlayer otherPlayer;
	public AbstractActionShareKnowledge(String name, String text, AbstractReferee referee, AbstractPlayer otherPlayer) {
		super(name, text, referee);
		this.otherPlayer = otherPlayer;
	}

	@Override
	public abstract void takeAction();

	@Override
	public abstract List<IRule> getRuleList();
	public AbstractPlayer getOtherPlayer() {
		return otherPlayer;
	}
}
