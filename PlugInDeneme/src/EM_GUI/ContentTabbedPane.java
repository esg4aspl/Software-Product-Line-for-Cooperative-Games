package EM_GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JTabbedPane;

public class ContentTabbedPane extends JTabbedPane {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public ContentTabbedPane(ArrayList<Component> panelList) {
			super(JTabbedPane.LEFT);
			this.setForeground(new Color(153, 0, 0));
			this.setFont(new Font("jdIcoMoonFree", Font.PLAIN, 20));
			this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			this.setBackground(Color.WHITE);
			this.setBounds(0, 251, 1000, 370);
			setPanelList(panelList);
		}
		
		private void setPanelList(ArrayList<Component> panelList) {
			int i = 0;
			for (Component panel : panelList) {
				this.add(panel);
				this.addTab(panel.getName(), null, panel, "");
				this.setEnabledAt(i, true);
				this.setBackgroundAt(0, Color.WHITE);
				i++;
			}
		}
}
