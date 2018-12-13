package EM_GUI;

import javax.swing.JPanel;

public class PnlRuleInfo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	public PnlRuleInfo(String name) {
		super();
		setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
