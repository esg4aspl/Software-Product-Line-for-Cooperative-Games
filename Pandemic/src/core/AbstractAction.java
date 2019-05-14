package core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAction {
	protected List<IRule> ruleList;
	protected String name;
	protected String text;
	protected AbstractReferee referee;
	
	
	public AbstractAction(String name,String text, AbstractReferee referee) {
		this.referee = referee;
		this.name = name;
		this.text=text;
		
		this.ruleList = new ArrayList<IRule>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getText() {
		return text;
	}
	
	public boolean isSatisfied() {
		boolean isSatisfied = true;
    	for (IRule rule : getRuleList()) {
			isSatisfied = isSatisfied && rule.evaluate(referee);
		}
		return isSatisfied;
	}
	public void addRule(IRule rule) {
		ruleList.add(rule);
	}
	public abstract void takeAction();
	public abstract List<IRule> getRuleList();
	
}
