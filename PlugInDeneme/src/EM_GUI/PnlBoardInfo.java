package EM_GUI;

import javax.swing.JPanel;

public class PnlBoardInfo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	public PnlBoardInfo(String name) {
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
