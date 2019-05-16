package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.Color;
import core.IView;

public class PandemicOriginalMainFrame extends JFrame implements IView{

	private JPanel contentPane;
	private PnlActionChoice pnlActionChoice;
	private PnlInformationPanel pnlInformationPanel;
	PnlForChosenCard pnlForChosenCard;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PandemicOriginalMainFrame frame = new PandemicOriginalMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public PandemicOriginalMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1766, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pnlActionChoice = new PnlActionChoice();
		
		//pnlActionChoice.setVisible(false);
		//getContentPane().add(pnlActionChoice);
		//pnlInformationPanel = new PnlInformationPanel();
		//add(pnlInformationPanel);
		
		
	}

	@Override
	public AbstractAction getActionChoiceFromPlayer(AbstractReferee referee) {
		
		//pnlActionChoice.setVisible(true);
		//pnlActionChoice.getSelectedAction();
		return null;
	}

	@Override
	public AbstractBoardNode getDestinationNodeFromPlayer(AbstractReferee referee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractPlayer whichplayerToShareInformationWith(AbstractReferee referee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showSetUpInformation() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color askDiseaseColor(AbstractReferee referee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractCard getChosenCardFromPlayer(AbstractDeck deck) {
		pnlForChosenCard = new PnlForChosenCard(deck.getDeck());
		this.add(pnlForChosenCard);
		
		
		
		return pnlForChosenCard.getChosenCard();
	}

}
