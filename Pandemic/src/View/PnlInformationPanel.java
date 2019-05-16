package View;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PnlInformationPanel extends JPanel {
	private JTextField textField;

	

	/**
	 * Create the panel.
	 */
	public PnlInformationPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(182, 5, 479, 426);
		add(textField);
		textField.setColumns(10);

	}
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

}
