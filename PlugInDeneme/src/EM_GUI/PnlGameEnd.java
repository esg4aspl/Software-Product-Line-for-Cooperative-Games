package EM_GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import EM_Config.ConfigWriter;

public class PnlGameEnd extends JPanel {
	private String name;
	private Color color;
	private Font font;
	public PnlGameEnd(String name,ConfigWriter cnfgModel) {
			setName(name);
			this.color = new Color(153, 0, 0);
			this.font = new Font("jdIcoMoonFree", Font.PLAIN, 13);
			this.setBackground(Color.WHITE);
			this.setLayout(null);
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
