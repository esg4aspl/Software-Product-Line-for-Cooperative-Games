package pandemicOriginal;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

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
import pandemicBase.ActionBuildResearchStation;
import pandemicBase.ActionCharterFlight;
import pandemicBase.ActionDirectFlight;
import pandemicBase.ActionDiscoverCure;
import pandemicBase.ActionDriveFerry;
import pandemicBase.ActionGiveKnowledge;
import pandemicBase.ActionShuttleFlight;
import pandemicBase.ActionTakeKnowledge;
import pandemicBase.ActionTreatDisease;
import pandemicBase.BoardNode;

public class PandemicOriginalMainFrame extends JFrame implements IView{

	private JPanel contentPane;
	
	public PandemicOriginalMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel imgholderPanel = new JPanel();
		
		imgholderPanel.setBounds(0, 0, 1500, 780);
		JLabel headerPic = new JLabel(new ImageIcon("PandemicImage.png"));
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
		 UI.put("OptionPane.okButtonText", " GOT IT! ");
		 
	}

	@Override
	public AbstractAction getActionChoiceFromPlayer(AbstractReferee referee) {
		AbstractAction action = null;
		JComboBox comboBox = new JComboBox();
		String[] actionName = {"Drive/Ferry","Direct Flight","Charter Flight","Shuttle Flight","Treat Disease","Discover Cure","Build Research Station","Take Knowledge","Give Knowledge"};
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
			AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
			action = new ActionShuttleFlight(referee, (BoardNode) destinationNode);	

		}
		else if(selectedAction==4) {
			Color color = askDiseaseColor(referee);
			action = new ActionTreatDisease(referee, color);
			
		}
		else if(selectedAction==5) {
			Color color =askDiseaseColor(referee);
			action =  new ActionDiscoverCure(referee,color);
			
			
		}
		else if(selectedAction==6) {
			action = new ActionBuildResearchStation(referee);
			
		}
		else if(selectedAction==7) {
			AbstractPlayer giverPlayer = whichplayerToShareInformationWith(referee);
			AbstractCard card = getChosenCardFromPlayer(giverPlayer.getHand());
			action =  new ActionTakeKnowledge(referee, giverPlayer, card);
		}
		else if(selectedAction==8) {
			AbstractPlayer takerPlayer = whichplayerToShareInformationWith(referee);
			AbstractCard card = getChosenCardFromPlayer(referee.getCurrentPlayer().getHand());
			action =  new ActionGiveKnowledge(referee, takerPlayer, card);
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
		
		AbstractPlayer player = (AbstractPlayer) comboBox.getSelectedItem();
		if(player == null) {
			JOptionPane.showMessageDialog( this,"You didn't choose anything. Please try again. ","NULL ERROR", JOptionPane.ERROR_MESSAGE);
			player  = whichplayerToShareInformationWith(referee);
		}
		return player;
	}

	@Override
	public void showSetUpInformation() {
			String textPandemic = "In Pandemic, you and your fellow players are members of a disease control team.\r\n" + 
			"You must work together to develop cures and prevent disease outbreaks, before 4 deadly diseases (Blue, Yellow, Black, and Red) contaminate humanity.\r\n" + 
			"Pandemic is a cooperative game. The players all win or lose together.\r\n" + 
			"The goal is to discover cures for all 4 diseases. The players lose if:\r\n" + 
			"--> 8 outbreaks occur (a worldwide panic happens),\r\n" + 
			"--> not enough disease cubes are left when needed (a disease spreads too much), or,\r\n" + 
			"--> not enough player cards are left when needed (your team runs out of time).\r\n" + 
			"Each player has a specific role with special abilities to improve the team’s chances.\r\n" + 
			""	;	

			JOptionPane.showMessageDialog(null, textPandemic, "PANDEMIC", JOptionPane.PLAIN_MESSAGE); //plain
			
			String textSetup = "Please always put releated disease cubes on cities according to board situation.\r\n" +
					"Set the game’s difficulty level, by using either 4, 5, or 6 Epidemic cards, for " + 
					"an Introductory, Standard, or Heroic game. Remove any unused Epidemic cards from the game.\r\n" + 
					"Divide the remaining player cards into face down piles, as equal in size as you can, \r\n"+
					"so that the number of piles matches the number of Epidemic cards " + 
					"you are using. Shuffle 1 Epidemic card into each pile, face down. \r\n"+ 
					"Stack these piles to form the Player Deck, placing smaller piles on the bottom. ";
			
			JOptionPane.showMessageDialog(null, textSetup, "GAME SET UP", JOptionPane.PLAIN_MESSAGE); //plain
			
			
			String textInfection = "Infection phase is done by computer. Each city can contain maximum 3 cubes of same color."+
					"If game tries to put another cube of same colored on the node\r\n"
					+ "then outbreak will occur which leads you to move outbreak marker forward.\r\n" ;
			
			JOptionPane.showMessageDialog(null, textInfection, "INFECTION", JOptionPane.PLAIN_MESSAGE); //plain
			
			String textHowToPlay = "Each player turn is divided into 2 parts:\r\n" + 
					"1. Do 4 actions.\r\n" + 
					"2. Draw 2 Player cards.\r\n" + 
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
				+ "3.Shuttle Flight\n Move from a city with a research station to any other city that has a research station.\n\n"
				+ "4.Treat Disease:\n Remove 1 disease cube from the city you are in, placing it in the cube.\n\n"
				+ "5.Discover Cure:\n At any research station, discard 5 City cards of the same color from your hand to cure the disease of that color.\n\n"
				+ "6.Build Research Station:\n\n Discard the City card that matches the city you are in to place a research station there.\n\n"
				+ "7.Take Knowledge:\n Take the City card that matches the city you are in from another player.The other player must also be in the city with you. Both of you need to agree to do this.\n\n" 
				+ "8.Give Knowlegde:\n Give the City card that matches the city you are in to another player. The other player must also be in the city with you. Both of you need to agree to do this. \n\n";
	
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
		JOptionPane.showMessageDialog(null, referee.getBoard(), "BOARD STATUE", JOptionPane.PLAIN_MESSAGE); //plain
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
