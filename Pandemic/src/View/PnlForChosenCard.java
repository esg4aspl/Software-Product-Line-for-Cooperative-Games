package View;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import core.AbstractCard;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PnlForChosenCard extends JPanel {
	List<AbstractCard> cardList;
	JComboBox<?> comboBox;
	AbstractCard card; 
	public PnlForChosenCard(List<AbstractCard> cardList) {
		this.cardList = cardList;
		
		setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(cardList.toArray()));
		comboBox.setBounds(73, 107, 285, 22);
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLUE);
		this.add(comboBox);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {	 
		    	  int state = itemEvent.getStateChange();
		    	  if(state == ItemEvent.SELECTED) {
		    		 Vector temp = new Vector<>();
		    		  for (int i = 0; i < cardList.size(); i++) {
		    			  if (!cardList.get(i).equals(itemEvent.getItem())) {
							temp.add(cardList.get(i));
						}
					}
		    		 comboBox.setModel(new DefaultComboBoxModel(temp.toArray()));
		    	 }
		      }
		    };
		comboBox.addItemListener(itemListener);
		
		
		
		JLabel lblNewLabel = new JLabel("CARD SEC");
		lblNewLabel.setBounds(73, 54, 307, 16);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(72, 142, 97, 25);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card = (AbstractCard)comboBox.getSelectedItem();
				
				
			}
		});

	}
	public AbstractCard getChosenCard() {
		return card;
	}
}
