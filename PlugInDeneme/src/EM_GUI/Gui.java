package EM_GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Gui() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBackground(new Color(51, 51, 51));
		frame.setFont(new Font("jdIcoMoonFree", Font.PLAIN, 15));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("boardGameIcon.png"));
		frame.setForeground(new Color(0, 0, 0));
		frame.setResizable(false);
		frame.setTitle("Cooperative Board Game SPL");
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 1001, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BufferedImage myPicture = ImageIO.read(new File("boardGame.png"));
		
		JLabel lblDesc = new JLabel("SPL for Cooperative Board Game");
		lblDesc.setForeground(new Color(153, 0, 0));
		lblDesc.setBounds(186, 200, 624, 37);
		lblDesc.setFont(new Font("jdIcoMoonFree", Font.BOLD, 28));
		lblDesc.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel imgholderPanel = new JPanel();
		imgholderPanel.setBackground(Color.WHITE);
		imgholderPanel.setBounds(201, 0, 581, 207);
		JLabel headerPic = new JLabel(new ImageIcon(myPicture));
		imgholderPanel.add(headerPic);
		headerPic.setBackground(Color.DARK_GRAY);
		
		PnlHeader headerPanel = new PnlHeader(imgholderPanel, lblDesc );
		frame.getContentPane().add(headerPanel);
		
		
		JPanel featureSelectionPanel = new PnlFeatureSelection("Feature Selection");
		JPanel boardInfoPanel = new PnlBoardInfo("Board Info");
		JPanel ruleInfoPanel = new PnlRuleInfo("Rule Info");
		ArrayList<JPanel> tabbedPanelList = new ArrayList<JPanel>();
		tabbedPanelList.add(featureSelectionPanel);
		tabbedPanelList.add(boardInfoPanel);
		tabbedPanelList.add(ruleInfoPanel);
		ContentTabbedPane contentTabbedPane = new ContentTabbedPane(tabbedPanelList);
		frame.getContentPane().add(contentTabbedPane);
		
	}
}
