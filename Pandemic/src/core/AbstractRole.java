package core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRole {
	
	private String name;
	private String text;
	private List<IRule> ruleList;
		
	public AbstractRole(String name, String text) {
		this.name = name;
		this.text = text;
		this.ruleList = new ArrayList<IRule>();
		  
	}
	protected void addRule(IRule rule) {
		ruleList.add(rule);
	}
	public String getText() {
		return text;
	}
	public String getName() {
		return name;
	}
	public List<IRule> getRuleList() {
		return ruleList;
	}
	public String toString() {
		return "You are " + name + "! " + 
				"Don't forget your special abilities:"  + text;
	}
}
