package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import core.AbstractAction;
import core.AbstractBoard;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
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
import javax.swing.JList;

public class PandemicOriginalMainFrame extends JFrame implements IView{

	private JPanel contentPane;
	private PnlActionChoice pnlActionChoice;
	private PnlInformationPanel pnlInformationPanel;
	PnlForChosenCard pnlForChosenCard;
	private JList listBoard;
	private AbstractReferee referee;
	
	
	
	/**
	 * Create the frame.
	 */
	public PandemicOriginalMainFrame(AbstractReferee referee) {
		this.referee = referee;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		
		pnlActionChoice = new PnlActionChoice();
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
		String text = " SELECT DESIRED ACTION FOR: " + referee.getCurrentPlayer().getRole().getName();
		JOptionPane.showMessageDialog( this, comboBox, text, JOptionPane.PLAIN_MESSAGE);
	
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
			showDeck(giverPlayer.getHand());
			AbstractCard card = getChosenCardFromPlayer(giverPlayer.getHand());
			action =  new ActionTakeKnowledge(referee, giverPlayer, card);
		}
		else if(selectedAction==8) {
			AbstractPlayer takerPlayer = whichplayerToShareInformationWith(referee);
			showDeck(referee.getCurrentPlayer().getHand());
			AbstractCard card = getChosenCardFromPlayer(referee.getCurrentPlayer().getHand());
			action =  new ActionGiveKnowledge(referee, takerPlayer, card);
		}
		else {
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
		
		JOptionPane.showMessageDialog( this, comboBox, "SELECT DESTINATION NODE", JOptionPane.PLAIN_MESSAGE);
		destinationNode = board.getBoardNode(((AbstractBoardNode)comboBox.getSelectedItem()).getName());
		if(destinationNode == null) {
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

		JOptionPane.showMessageDialog( this, comboBox, "SELECT PLAYER", JOptionPane.PLAIN_MESSAGE);

		AbstractPlayer player = (AbstractPlayer) comboBox.getSelectedItem();
		if(player == null) {
			player  = whichplayerToShareInformationWith(referee);
		}
		return player;
	}

	@Override
	public void showSetUpInformation() {
	

			String text = "***********WHAT IS PANDEMIC?************\n" + "In Pandemic, you and your fellow players are members of a disease control team.\r" + 
			"You must work together to develop cures and prevent disease outbreaks, before 4 deadly diseases (Blue, Yellow, Black, and Red) contaminate humanity.\r\n" + 
			"Pandemic is a cooperative game. The players all win or lose together.\r\n" + 
			"The goal is to discover cures for all 4 diseases. The players lose if:\r\n" + 
			"• 8 outbreaks occur (a worldwide panic happens),\r\n" + 
			"• not enough disease cubes are left when needed (a disease spreads too much), or,\r\n" + 
			"• not enough player cards are left when needed (your team runs out of time).\r\n" + 
			"Each player has a specific role with special abilities to improve the team’s chances.\r\n" + 
			""	;	
			
			JOptionPane.showMessageDialog(null, text, "GAME SET UP", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void showDeck(AbstractDeck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showActionOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showResponseToPlayer(String message) {
		JOptionPane.showMessageDialog(null, message, "INFO SCREEN", JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void announceWinner(String winner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showNewlyInfectedNodeList(AbstractReferee referee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showBoardStatue(AbstractReferee referee) {
		
		System.out.println(referee.getBoard().getNodeList());
	}

	@Override
	public Color askDiseaseColor(AbstractReferee referee) {
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(referee.getUsedColorSet().toArray()));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(12, 98, 410, 41);
		comboBox.setEditable(true);
		JOptionPane.showMessageDialog( this, comboBox, "SELECT COLOR", JOptionPane.PLAIN_MESSAGE);
		Color color = (Color) comboBox.getSelectedItem();
		if(color == null) {
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
		String text = "DRAWN CARD" ;
		JOptionPane.showMessageDialog( this, comboBox, text, JOptionPane.PLAIN_MESSAGE);
	
		AbstractCard selectedCard = (AbstractCard) comboBox.getSelectedItem();
		if (selectedCard == null) {
			selectedCard = getChosenCardFromPlayer(deck);
		}
		
		return selectedCard;
	}
}
