package EM_GUI;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.soap.Node;

import EM_Config.ConfigWriter;

public class PnlRuleInfo extends JTabbedPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private JPanel pnlTurnInfo;
	private JPanel pnlGameEnd;
	private JPanel pnlMovementInfo;
	private JPanel pnlGameSetUp;
	private ConfigWriter cnfgModel;
	
	
	public PnlRuleInfo(String name,ConfigWriter cnfgWriter) {
		super(JTabbedPane.TOP);
		setName(name);
		this.setForeground(new Color(153, 0, 0));
		this.setFont(new Font("jdIcoMoonFree", Font.PLAIN, 20));
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		this.setBackground(Color.WHITE);
		this.setBounds(0, 251, 1000, 370);
		
		this.pnlGameSetUp = new PnlGameSetUp("Game Set-Up",cnfgModel);
		this.pnlTurnInfo = new PnlTurnInfo("Turn Info",cnfgModel);
		this.pnlMovementInfo = new PnlMovementInfo("Movement Info",cnfgModel);
		this.pnlGameEnd = new PnlGameEnd("Game End",cnfgModel);
		
		ArrayList<JPanel> tabbedPanelList = new ArrayList<JPanel>();
		tabbedPanelList.add(pnlGameSetUp);
		tabbedPanelList.add(pnlTurnInfo);
		tabbedPanelList.add(pnlMovementInfo);
		tabbedPanelList.add(pnlGameEnd);
		setPanelList(tabbedPanelList);

		//this.pnlGameRuleInfo = new PnlGameRuleInfo(this,cnfgWriter);
		//this.add(pnlGameRuleInfo,"GAME RULE INFO");
		

		
}
	
	private void setPanelList(ArrayList<JPanel> panelList) {
		int i = 0;
		for (JPanel panel : panelList) {
			this.add(panel);
			this.addTab(panel.getName(), null, panel, "");
			this.setEnabledAt(i, true);
			this.setBackgroundAt(0, Color.WHITE);
			i++;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}





}
