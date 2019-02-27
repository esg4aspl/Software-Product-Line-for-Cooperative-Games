package EM_GUI;

import EM_Config.ConfigWriter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;
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
	private ConfigWriter cnfgModel; 

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
	 * @throws ParserConfigurationException 
	 */
	public Gui() throws IOException, ParserConfigurationException {
		cnfgModel = new ConfigWriter();
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
		
		JLabel lblDesc = new JLabel("SPL for Pandemic Game Versions");
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
		
		
		JPanel featureSelectionPanel = new PnlFeatureSelection("Feature Selection",cnfgModel);
		JPanel boardInfoPanel = new PnlBoardInfo("Board Info",cnfgModel);
		JTabbedPane ruleInfoPanel = new PnlRuleInfo("Rule Info",cnfgModel);
		JPanel meterInfoPanel = new PnlMeterInfo("Meter Info",cnfgModel);
		JPanel readFromXMLPanel = new PnlReadXML("Read From File",cnfgModel);
		ArrayList<Component> tabbedPanelList = new ArrayList<Component>();
		tabbedPanelList.add(featureSelectionPanel);
		tabbedPanelList.add(boardInfoPanel);
		tabbedPanelList.add(ruleInfoPanel);
		tabbedPanelList.add(meterInfoPanel);
		tabbedPanelList.add(readFromXMLPanel);
		ContentTabbedPane contentTabbedPane = new ContentTabbedPane(tabbedPanelList);
		frame.getContentPane().add(contentTabbedPane);
		
	}
}