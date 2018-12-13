package EM_GUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlHeader extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PnlHeader(JPanel pnlImage, JLabel lblDesc ) {
		//BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\user\\Documents\\TEZ\\boardGame.png"));
		super();
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 1000, 250);
		this.setLayout(null);
		
		this.add(pnlImage);
		this.add(lblDesc);
	}
}
