package PandemicKids;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.TableColumn;

import core.AbstractAction;
import core.AbstractBoard;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.AbstractTrack;
import core.Color;
import core.IView;
import pandemicBase.ActionCharterFlight;
import pandemicBase.ActionDirectFlight;
import pandemicBase.ActionDriveFerry;
import pandemicBase.ActionGiveKnowledge;
import pandemicBase.BoardNode;

public class PandemicKidsMainFrame extends JFrame implements IView{

	private JPanel contentPane;
	
	public PandemicKidsMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel imgholderPanel = new JPanel();
		
		imgholderPanel.setBounds(0, 0, 1500, 780);
		JLabel headerPic = new JLabel(new ImageIcon("gandalf.jpg"));
		imgholderPanel.add(headerPic);
		contentPane.add(imgholderPanel);
		
		setPreferredSize(new Dimension(1500, 780));
	    pack();
	    setLocationRelativeTo(null);
		
		
		setVisible(true);
		 UIManager UI=new UIManager();
		 UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
		 UIManager.put("Panel.background",new ColorUIResource(255,255,255));
		 Font font = new Font("jdIcoMoonFree", Font.PLAIN, 16) ;
		 UIManager.put("OptionPane.messageFont", new FontUIResource(font)); 
		 UIManager.put("OptionPane.okButtonText", " GOT IT! ");
		 
	}

	@Override
	public AbstractAction getActionChoiceFromPlayer(AbstractReferee referee) {
		AbstractAction action = null;
		JComboBox comboBox = new JComboBox();
		String[] actionName = {"Drive/Ferry","Direct Flight","Charter Flight","Break a curse","Build Research Station","Give Knowledge"};
		comboBox.setModel(new DefaultComboBoxModel(actionName));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		JOptionPane.showMessageDialog( this, comboBox, "ACTION SELECTION", JOptionPane.PLAIN_MESSAGE);
		 
	
		int selectedAction= comboBox.getSelectedIndex();
		if(selectedAction == 0) {
			AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
			action = new ActionDriveFerry(referee, (BoardNode) destinationNode);
		}
		else if(selectedAction==1) {
			AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
			action = new ActionDirectFlight(referee, (BoardNode) destinationNode);
			
		}
		else if(selectedAction==2) {
			AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
			action = new ActionCharterFlight(referee, (BoardNode) destinationNode);
		}
		else if(selectedAction==3) {
			Color color = askDiseaseColor(referee);
			action =new ActionBreakCurse(referee, color);

		}
		else if(selectedAction==4) {
			AbstractPlayer takerPlayer = whichplayerToShareInformationWith(referee);
			AbstractCard card = getChosenCardFromPlayer(referee.getCurrentPlayer().getHand());
			action= new ActionGiveKnowledge(referee, takerPlayer, card);		
		}
		else {
			JOptionPane.showMessageDialog( this,"You didn't choose anything. Please try again. ","NULL ERROR", JOptionPane.ERROR_MESSAGE);
			action = getActionChoiceFromPlayer(referee);
		}
		return action;
	}

	@Override
	public AbstractBoardNode getDestinationNodeFromPlayer(AbstractReferee referee) {
		AbstractBoard board = referee.getBoard();
		
		AbstractBoardNode destinationNode = null;
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(board.getNodeList().toArray()));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		
		JOptionPane.showMessageDialog( this, comboBox, "DESTINATION NODE SELECTION", JOptionPane.PLAIN_MESSAGE);
	
		destinationNode = board.getBoardNode(((AbstractBoardNode)comboBox.getSelectedItem()).getName());
		if(destinationNode == null) {
			JOptionPane.showMessageDialog( this,"You didn't choose anything. Please try again. ","NULL ERROR", JOptionPane.ERROR_MESSAGE);
			destinationNode = getDestinationNodeFromPlayer(referee);
		}
		return destinationNode;
	}

	@Override
	public AbstractPlayer whichplayerToShareInformationWith(AbstractReferee referee) {
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(referee.getPlayerList().getPlayers().toArray()));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		JOptionPane.showMessageDialog( this, comboBox, "PLAYER SELECTION", JOptionPane.PLAIN_MESSAGE);
		
		int index = comboBox.getSelectedIndex();
		AbstractPlayer player;
		if(index == -1) {
			JOptionPane.showMessageDialog( this,"You didn't choose anything. Please try again. ","NULL ERROR", JOptionPane.ERROR_MESSAGE);
			player  = whichplayerToShareInformationWith(referee);
		}
		player = referee.getPlayerList().getPlayer(index);
		return player;
	}

	@Override
	public void showSetUpInformation() {
			String textPandemic = "In PandemicKids, you and your fellow players are members of a curse breakers team.\r\n" + 
					"You must work together to find magic and resist the spread of curses , before 3 deadly curses (Blue, Yellow, and Red) contaminate humanity.\r\n" + 
					"Pandemic is a cooperative game. The players all win or lose together.\r\n" + 
					"The goal is to eradicate of all 3 curses. The players lose if:\r\n" + 
					"--> 8 spread of curses (a worldwide panic happens),\r\n" + 
					"--> not enough curses are left when needed (a demons spreads too much), or,\r\n" + 
					"--> not enough player cards are left when needed (your team runs out of time).\r\n" + 
					"Each player has a specific role with special abilities to improve the team’s chances.\r\n" + 
					"" 	;	

			JOptionPane.showMessageDialog(null, textPandemic, "PANDEMIC KIDS", JOptionPane.PLAIN_MESSAGE); //plain
			
			String textSetup = "Please always put releated disease cubes on cities according to board situation.\r\n" +
					"Set the game’s difficulty level, by using either 4, 5, or 6 Chaos cards, for " + 
					"an Introductory, Standard, or Heroic game. Remove any unused Chaos cards from the game.\r\n" + 
					"Divide the remaining player cards into face down piles, as equal in size as you can, \r\n"+
					"so that the number of piles matches the number of Chaos cards " + 
					"you are using. Shuffle 1 Epidemic card into each pile, face down. \r\n"+ 
					"Stack these piles to form the Player Deck, placing smaller piles on the bottom. ";
			
			JOptionPane.showMessageDialog(null, textSetup, "GAME SET UP", JOptionPane.PLAIN_MESSAGE); //plain
			
			
			String textInfection = "Infection phase is done by computer. Each city can contain maximum 3 cubes of same color."+
					"If game tries to put another cube of same colored on the node\r\n"
					+ "then outbreak will occur which leads you to move outbreak marker forward.\r\n" ;
			
			JOptionPane.showMessageDialog(null, textInfection, "CURSE SPREAD", JOptionPane.PLAIN_MESSAGE); //plain
			
			String textHowToPlay = "Each player turn is divided into 2 parts:\r\n" + 
					"1. Do 4 actions.\r\n" + 
					"2. Draw 1 Player card.\r\n" + 
					"After a player is done the game infects cities,after game phase next player plays.\r\n" + 
					"Players should freely give each other advice. \r\n" + 
					"Let everyone offer opinions and ideas. However, the player whose turn it is decides what to do.\r\n" + 
					"Your hand is limited with 7 cards.Whenever you have more than 7 cards, discard one of them immediately. \r\n" ;
			
			JOptionPane.showMessageDialog(null, textHowToPlay, "HOW TO PLAY", JOptionPane.PLAIN_MESSAGE); //plain
			
			
			
	}



	@Override
	public void showActionOptions() {
		String output = "0.Drive or Ferry:\n Move to a city connected by a white line to the one you are in.\n\n"
				+ "1.Direct Flight:\n Discard a City card to move to the city named on the card.\n\n"
				+ "2.Charter Flight:\n Discard the City card that matches the city you are in to move to any city.\n\n"
				+ "3.Break a curse:\n Remove 1 demon figure from the city you are in, placing it in the cube.\n\n"
				+ "4.Give Knowlegde:\n Give the City card that matches the city you are in to another player. The other player must also be in the city with you. Both of you need to agree to do this.\n\n";
	
		JOptionPane.showMessageDialog(null, output, "ACTION OPTIONS", JOptionPane.PLAIN_MESSAGE);
	
	}

	@Override
	public void showResponseToPlayer(String message) {
		JOptionPane.showMessageDialog(null, message, "INFO SCREEN", JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void announceWinner(String winner) {
		String output ="Game Ends : " + winner;	
		JOptionPane.showMessageDialog(null, output, "GAME END", JOptionPane.PLAIN_MESSAGE); //plain
	}

	@Override
	public void showNewlyInfectedNodeList(AbstractReferee referee) {
		List<AbstractBoardNode> newlyInfectedNodeList = referee.getNewlyInfectedNodeList();
		if(newlyInfectedNodeList.size() != 0) {
			for (AbstractBoardNode node : newlyInfectedNodeList) {
				JOptionPane.showMessageDialog(null, node.toString(), "NEWLY INFECTED CITIES", JOptionPane.PLAIN_MESSAGE); //plain
			}
		}
		else {
			JOptionPane.showMessageDialog(null," You are lucky! No city is infected! ", "NEWLY INFECTED CITIES", JOptionPane.PLAIN_MESSAGE); //plain
		}
		AbstractTrack outbreakTrack = referee.getOutbreakTrack();
		JOptionPane.showMessageDialog(null,outbreakTrack.toString(), "OUTBREAK TRACK", JOptionPane.PLAIN_MESSAGE); //plain
		
	}

	@Override
	public void showBoardStatue(AbstractReferee referee) {
		List<AbstractBoardNode> nodeList = referee.getBoard().getNodeList();
		ArrayList<ArrayList<String>>values = new ArrayList<ArrayList<String>>();
		
		for(AbstractBoardNode node : nodeList) {
			ArrayList<String> subValues = new ArrayList<String>();
			subValues.add(node.getName());
			String cubes = ""; 
			for(Color color: referee.getUsedColorSet()) {
				if(((BoardNode)node).doesHaveSpecificColoredCube(color)) {
					int numOfSameColoredCube = ((BoardNode)node).howManyCubesDoesHave(color);
					 cubes = color + ": "+ numOfSameColoredCube + " " ;
				}
			}
			subValues.add( cubes );
			values.add(subValues);
		}	
			String[][] array = new String[values.size()][];
			for (int i = 0; i < values.size(); i++) {
			    ArrayList<String> row = values.get(i);
			    array[i] = row.toArray(new String[row.size()]);
			}
		

			Object[] cols = {
					"City Name","Curses"
			};
			JTable table = new JTable(array, cols);
			
			for(int i=0; i<table.getRowCount();i++) {
				table.setRowHeight(i, 30);
			}
			
			
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);    
		    TableColumn col0 = table.getColumnModel().getColumn(0);
		    int width0 = 100;
		    col0.setPreferredWidth(width0);
		    
		    TableColumn col1 = table.getColumnModel().getColumn(1);
		    int width1 = 250;
		    col1.setPreferredWidth(width1);
			
			JScrollPane scrollPane = new JScrollPane(table);
			
	        JOptionPane.showMessageDialog(null,  new JScrollPane(table), "BOARD STATUE", JOptionPane.PLAIN_MESSAGE); //plain
	}

	@Override
	public Color askDiseaseColor(AbstractReferee referee) {
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(referee.getUsedColorSet().toArray()));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		JOptionPane.showMessageDialog( this, comboBox, "COLOR SELECTION", JOptionPane.PLAIN_MESSAGE);
		Color color = (Color) comboBox.getSelectedItem();
		if(color == null) {
			JOptionPane.showMessageDialog( this,"You didn't choose anything. Please try again. ","NULL ERROR", JOptionPane.ERROR_MESSAGE);
			color = askDiseaseColor(referee);
		}
		return color;
	}

	@Override
	public AbstractCard getChosenCardFromPlayer(AbstractDeck deck) {
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(deck.getDeck().toArray()));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		String text = "CARD SELECTION";
		JOptionPane.showMessageDialog( this, comboBox, text, JOptionPane.PLAIN_MESSAGE);
		
		AbstractCard selectedCard = (AbstractCard) comboBox.getSelectedItem();
		if (selectedCard == null) {
			JOptionPane.showMessageDialog( this,"You didn't choose anything. Please try again. ","NULL ERROR", JOptionPane.ERROR_MESSAGE);
			selectedCard = getChosenCardFromPlayer(deck);
		}
		
		return selectedCard;
	}
}
