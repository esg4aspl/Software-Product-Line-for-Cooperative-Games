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
	JComboBox<?> cardBox;
	AbstractCard card; 
	public PnlForChosenCard(List<AbstractCard> cardList) {
		this.cardList = cardList;
		
		setLayout(null);
		
		cardBox = new JComboBox();
		cardBox.setModel(new DefaultComboBoxModel(cardList.toArray()));
		cardBox.setBounds(12, 83, 285, 22);
		cardBox.setBackground(Color.WHITE);
		cardBox.setForeground(Color.BLUE);
		this.add(cardBox);
		
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
		    		 cardBox.setModel(new DefaultComboBoxModel(temp.toArray()));
		    	 }
		      }
		    };
		cardBox.addItemListener(itemListener);
		
		
		
		JLabel lblCardSelectionInfo = new JLabel("CARD SEC");
		lblCardSelectionInfo.setBounds(12, 54, 285, 16);
		add(lblCardSelectionInfo);
		
		JButton btnAdd = new JButton("New button");
		btnAdd.setBounds(12, 118, 285, 25);
		add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card = (AbstractCard)cardBox.getSelectedItem();
				
				
			}
		});

	}
	public AbstractCard getChosenCard() {
		return card;
	}
}
