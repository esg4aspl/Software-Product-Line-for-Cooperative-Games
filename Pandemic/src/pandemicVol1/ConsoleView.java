package pandemicVol1;

import java.util.List;
import java.util.Scanner;

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

public class ConsoleView implements IView {
	
	private Scanner scanner = null;
	
	public ConsoleView() {
		scanner = new Scanner(System.in);
	}

	
	@Override
	public void showResponseToPlayer(String message) {
		System.out.println(message);
	}


	@Override
	public AbstractAction getActionChoiceFromPlayer(AbstractReferee referee) {
		while(true) {
			System.out.println("Enter the number of the action:");
			int input = scanner.nextInt();
			if(input == 0) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionDriveFerry(referee, (BoardNode) destinationNode);
				
				
			}
			else if(input==1) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionDirectFlight(referee, (BoardNode) destinationNode);
				
			}
			else if(input==2) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionCharterFlight(referee, (BoardNode) destinationNode);
			}
			else if(input==3) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionShuttleFlight(referee, (BoardNode) destinationNode);	

			}
			else if(input==4) {
				Color color = askDiseaseColor(referee);
				return new ActionTreatDisease(referee, color);
				
			}
			else if(input==5) {
				Color color =askDiseaseColor(referee);
				return new ActionDiscoverCure(referee,color);
				
				
			}
			else if(input==6) {
				return new ActionBuildResearchStation(referee);
				
			}
			else if(input==7) {
				AbstractPlayer giverPlayer = whichplayerToShareInformationWith(referee);
				showDeck(giverPlayer.getHand());
				AbstractCard card = getChosenCardFromPlayer(giverPlayer.getHand());
				return new ActionTakeKnowledge(referee, giverPlayer, card);
			}
			else if(input==8) {
				AbstractPlayer takerPlayer = whichplayerToShareInformationWith(referee);
				showDeck(referee.getCurrentPlayer().getHand());
				AbstractCard card = getChosenCardFromPlayer(referee.getCurrentPlayer().getHand());
				return new ActionGiveKnowledge(referee, takerPlayer, card);
				
			}
			else {
				System.out.println("Invalid number of action,try again");
			}
		}
		
	}

	@Override
	public AbstractBoardNode getDestinationNodeFromPlayer(AbstractReferee referee) {
		AbstractBoard board = referee.getBoard();
		System.out.println("Enter the destination city:");
		String destinationName = scanner.nextLine();
		destinationName = scanner.nextLine();
		AbstractBoardNode destinationNode = board.getBoardNode(destinationName.toUpperCase());
		while(destinationNode==null) {
			System.out.println("Invalid city name,try again:");
			System.out.println("Enter the destination city:");
			destinationName = scanner.nextLine();
			destinationNode = board.getBoardNode(destinationName.toUpperCase());
		}
		return destinationNode;
	}

	@Override
	public AbstractCard getChosenCardFromPlayer(AbstractDeck deck) {
		while(true) {
		System.out.println("Enter the number of the card you draw");
		int input = scanner.nextInt();
		//AbstractDeck playDeck = referee.getPlayerDeck();
		for(AbstractCard card : deck.getDeck()) {
			if(card.getID() == input) {
				return card;
			}
		}
		System.out.println("Invalid card number,try again:");
	}
		
	}

	@Override
	public List<AbstractCard> getHandDeckFromPlayer() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void announceWinner(String winner) {
		System.out.println("winner is : " + winner);
		
	}

	@Override
	public void showDeck(AbstractDeck deck) {
		System.out.println(deck.showDeck()); 
	}

	@Override
	public AbstractPlayer whichplayerToShareInformationWith(AbstractReferee referee) {
		while(true) {
		System.out.println("With which player you will share information ? (Enter the role name)");
		String input = scanner.nextLine();
		input = scanner.nextLine();
		for(AbstractPlayer player : referee.getPlayerList().getPlayers()) {
			if(player.getRole().getName().toUpperCase().equals(input.toUpperCase())) {
				return player;
			}
		}
		System.out.println("Invalid name,try again.");
	}
		
	}

	@Override
	public void showActionOptions() {
		String output = "0.Drive or Ferry:\n Move to a city connected by a white line to the one you are in.\n"
				+ "1.Direct Flight:\n Discard a City card to move to the city named on the card.\n"
				+ "2.Charter Flight:\n Discard the City card that matches the city you are in to move to any city.\n"
				+ "3.Shuttle Flight\n Move from a city with a research station to any other city that has a research station.\n"
				+ "4.Treat Disease:\n Remove 1 disease cube from the city you are in, placing it in the cube.\n"
				+ "5.Discover Cure:\n At any research station, discard 5 City cards of the same color from your hand to cure the disease of that color.\n"
				+ "6.Build Research Station:\n Discard the City card that matches the city you are in to place a research station there.\n"
				+ "7.Take Knowledge:\n Take the City card that matches the city you are in from another player.The other player must also be in the city with you. Both of you need to agree to do this. \n" 
				+ "8.Give Knowlegde:\n Give the City card that matches the city you are in to another player. The other player must also be in the city with you. Both of you need to agree to do this. \n";
		System.out.println(output);
		
	}


	@Override
	public void showNewlyInfectedNodeList(AbstractReferee referee) {
		List<AbstractBoardNode> newlyInfectedNodeList = referee.getNewlyInfectedNodeList();
		for (AbstractBoardNode node : newlyInfectedNodeList) {
			System.out.println(node.toString());
		}
		AbstractTrack outbreakTrack = referee.getOutbreakTrack();
		System.out.println(outbreakTrack.toString());
	}


	@Override
	public void showBoardStatue(AbstractReferee referee) {
		AbstractBoard board = referee.getBoard();
		for (AbstractBoardNode node : board.getNodeList()) {
			System.out.println(node.toString());
		}
		AbstractTrack outbreakTrack = referee.getOutbreakTrack();
		System.out.println(outbreakTrack.toString());

		
	}

	@Override
	public Color askDiseaseColor(AbstractReferee referee) {
		System.out.println("Available colors:");
		for(Color color : referee.getUsedColorSet()) {
			System.out.println(color.name());
		}
		while(true) { 
		System.out.println("Enter the name of the diseas color you want to use:");
			String input = scanner.nextLine();
			input = scanner.nextLine();
			for(Color color : referee.getUsedColorSet()) {
				if(input.toUpperCase().equals(color.name())) {
					return color;
				}
			}
		}
	}

	@Override
	public void showSetUpInformation() {
		System.out.println(
				"In Pandemic, you and your fellow players are members of a disease control team.\r" + 
				"You must work together to develop cures and prevent disease outbreaks, before 4 deadly diseases (Blue, Yellow, Black, and Red) contaminate humanity.\r\n" + 
				"Pandemic is a cooperative game. The players all win or lose together.\r\n" + 
				"The goal is to discover cures for all 4 diseases. The players lose if:\r\n" + 
				"• 8 outbreaks occur (a worldwide panic happens),\r\n" + 
				"• not enough disease cubes are left when needed (a disease spreads too much), or,\r\n" + 
				"• not enough player cards are left when needed (your team runs out of time).\r\n" + 
				"Each player has a specific role with special abilities to improve the team’s chances.\r\n" + 
				"");
		System.out.println("Each player turn is divided into 3 parts:\r\n" + 
				"1. Do 4 actions.\r\n" + 
				"2. Draw 2 Player cards.\r\n" + 
				"3. Infect cities.\r\n" + 
				"After a player is done infecting cities, next player plays.\r\n" + 
				"Players should freely give each other advice. \r\n" + 
				"Let everyone offer opinions and ideas. However, the player whose turn it is decides what to do.\r\n" + 
				"Your hand is limited with 7 cards.Whenever you have more than 7 cards, discard one of them immediately. \r\n" );
	}
}
