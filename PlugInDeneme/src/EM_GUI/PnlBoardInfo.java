package EM_GUI;

import java.awt.CardLayout;
import javax.swing.JPanel;

import EM_Config.ConfigWriter;
import EM_Config.ConfigWriterTemplate;

public class PnlBoardInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	private String name;
	private PnlNodeInfo pnlNodeInfo;
	
	public PnlBoardInfo(String name,ConfigWriterTemplate cnfgWriter) {
		setName(name);
		this.setLayout(new CardLayout(0,0));
		this.pnlNodeInfo = new PnlNodeInfo(this,cnfgWriter);
		this.add(pnlNodeInfo,"NODE");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
