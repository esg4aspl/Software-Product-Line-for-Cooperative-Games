package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.AbstractCard;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DialogForCardChoose  {
	JComboBox comboBox;
	AbstractCard selectedCard;
	List<AbstractCard> playerDeck;
	boolean isSelected;
	ActionListenerCardChoose selectAction;
	public DialogForCardChoose(List<AbstractCard> playerDeck) {
		this.playerDeck=playerDeck;
		this.isSelected = false;
		
		
		
	}
	
	public AbstractCard getSelectedCard() {
		JOptionPane.showMessageDialog(null, getPanel(),"Drawn Card",JOptionPane.OK_CANCEL_OPTION);
		return (AbstractCard) comboBox.getSelectedItem();
	}
	
	private JPanel getPanel() {
		JPanel panel= new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(100, 100, 450, 300);
		
		panel.setVisible(true);
		panel.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(playerDeck.toArray()));
		comboBox.setSelectedIndex(0);
		comboBox.setBackground(new Color(238, 130, 238));
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		panel.add(comboBox);
		
		
		JButton btnSelectCard = new JButton("SELECT CARD");
		btnSelectCard.setBackground(new Color(255, 255, 255));
		btnSelectCard.setForeground(new Color(128, 0, 0));
		btnSelectCard.setBounds(12, 152, 410, 41);
		panel.add(btnSelectCard);
		btnSelectCard.setEnabled(false);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {	 
		    	  int state = itemEvent.getStateChange();
		    	  if(state == ItemEvent.SELECTED) {
		    		  for (int i = 0; i < playerDeck.size(); i++) {
		    			  if (playerDeck.get(i).equals(itemEvent.getItem())) {
							btnSelectCard.setEnabled(true);
							
						}
					}
		    	 }
		      }
		    };
		    comboBox.addItemListener(itemListener);
		
		
		
		selectAction = new ActionListenerCardChoose(comboBox);
		btnSelectCard.addActionListener(selectAction);
		

		JLabel lblPlayerInfo = new JLabel("");
		lblPlayerInfo.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblPlayerInfo.setBounds(12, 13, 410, 66);
		panel.add(lblPlayerInfo);
		lblPlayerInfo.setText("Player 1 select your drawn card.");
		
		
		
		return panel;
	}
	
}
