package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.AbstractCard;

public class PnlDialogForCardSelection extends JPanel {

	/**
	 * Create the panel.
	 */
	List<AbstractCard> playerDeck;
	JComboBox comboBox;
	public PnlDialogForCardSelection(List<AbstractCard> playerDeck) {
		this.setBackground(new Color(255, 240, 245));
		this.setBounds(100, 100, 450, 300);
		
		this.setVisible(true);
		this.setLayout(null);
		
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(playerDeck.toArray()));
		comboBox.setSelectedIndex(0);
		comboBox.setBackground(new Color(238, 130, 238));
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		this.add(comboBox);
		
		
		JButton btnSelectCard = new JButton("SELECT CARD");
		btnSelectCard.setBackground(new Color(255, 255, 255));
		btnSelectCard.setForeground(new Color(128, 0, 0));
		btnSelectCard.setBounds(12, 152, 410, 41);
		this.add(btnSelectCard);
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
		
		

		JLabel lblPlayerInfo = new JLabel("");
		lblPlayerInfo.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblPlayerInfo.setBounds(12, 13, 410, 66);
		this.add(lblPlayerInfo);
		lblPlayerInfo.setText("Player 1 select your drawn card.");
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
