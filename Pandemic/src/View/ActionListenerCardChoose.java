package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import core.AbstractCard;

public class ActionListenerCardChoose implements ActionListener{
	private boolean isSelected;
	private AbstractCard selectedCard;
	private JComboBox comboBox;
	
	public ActionListenerCardChoose(JComboBox comboBox) {
		this.comboBox = comboBox;
		isSelected = false;
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		AbstractCard card = (AbstractCard)comboBox.getSelectedItem();
		setSelectedCard(card);
		System.out.println(selectedCard);
		setSelected(true);
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public AbstractCard getSelectedCard() {
		return selectedCard;
	}
	public void setSelectedCard(AbstractCard selectedCard) {
		this.selectedCard = selectedCard;
	}
	
}
