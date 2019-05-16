package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ActionSelectionButtonListener implements ActionListener{
	JButton button;
	public ActionSelectionButtonListener(JButton button) {
		this.button = button;
	}
	public String getActionChoice(){
		System.out.println("TIKLANDIM");
		return button.getText();
	}
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("abvvvv");
	}
	
}
