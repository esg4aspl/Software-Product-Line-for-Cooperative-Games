package pandemicBase;

import java.util.List;
import java.util.Scanner;

import core.AbstractAction;
import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractDeck;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IView;

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
				return new ActionBuildResearchStation(referee);
			}
			else if(input==1) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionCharterFlight(referee, (BoardNode) destinationNode);
			}
			else if(input==2) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionDirectFlight(referee, (BoardNode) destinationNode);		
			}
			else if(input==3) {
				//TODO PLEASE ADD COLOR
				return new ActionDiscoverCure(referee, null);
			}
			else if(input==4) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionDriveFerry(referee, (BoardNode) destinationNode);
			}
			else if(input==5) {
				AbstractPlayer takerPlayer = whichplayerToShareInformationWith(referee);
				//TODO PLEASE ADD WHICH CARD
				return new ActionGiveKnowledge(referee, takerPlayer, null);
			}
			else if(input==6) {
				AbstractBoardNode destinationNode = getDestinationNodeFromPlayer(referee);
				return new ActionShuttleFlight(referee, (BoardNode) destinationNode);	
			}
			else if(input==7) {
				AbstractPlayer giverPlayer = whichplayerToShareInformationWith(referee);
				//TODO PLEASE ADD WHICH CARD
				return new ActionTakeKnowledge(referee, giverPlayer, null);
				
			}
			else if(input==8) {
				//TODO PLEASE ADD COLOR
				return new ActionTreatDisease(referee, null);
			}
			else {
				System.out.println("Invalid number of action,try again");
			}
		}
		
	}

	@Override
	public AbstractBoardNode getDestinationNodeFromPlayer(AbstractReferee referee) {
		while(true) {
			System.out.println("Enter the destination city:");
			String input = scanner.nextLine();
			for(AbstractBoardNode node : referee.getBoard().getNodeList()) {
				if(node.getName().toUpperCase().equals(input.toUpperCase())) {
					return node;
				}
			}
			System.out.println("Invalid city name,try again:");
		}
	}

	@Override
	public AbstractCard getChosenCardFromPlayer(AbstractReferee referee) {
		while(true) {
		System.out.println("Enter the number of the card you draw");
		int input = scanner.nextInt();
		AbstractDeck playDeck = referee.getPlayerDeck();
		for(AbstractCard card : playDeck.getDeck()) {
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
		String output = "0.Build Research Station\n"
				+ "1.Charter Flight\n"
				+ "2.Direct Flight\n"
				+ "3.Discover Cure\n"
				+ "4.Drive or Ferry\n"
				+ "5.Give Knowledge\n"
				+ "6.Shuttle Flight\n"
				+ "7.Take Knowledgen\n"
				+ "8.Treat Disease\n";
		System.out.println(output);
		
	}


	@Override
	public void showNewlyInfectedNodeList(AbstractReferee referee) {
		List<AbstractBoardNode> newlyInfectedNodeList = referee.getNewlyInfectedNodeList();
		for (AbstractBoardNode node : newlyInfectedNodeList) {
			System.out.println(node.toString());
		}
		
		
	}

}
