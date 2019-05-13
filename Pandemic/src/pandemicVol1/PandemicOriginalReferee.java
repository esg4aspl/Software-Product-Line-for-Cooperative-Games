package pandemicVol1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import core.AbstractBoardNode;
import core.AbstractCard;
import core.AbstractDeck;
import core.AbstractGameConfiguration;
import core.AbstractGamePiece;
import core.AbstractHandDeck;
import core.AbstractInfection;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.AbstractRole;
import core.Color;
import core.IRule;
import pandemicBase.Board;
import pandemicBase.BoardNode;
import pandemicBase.CityCard;
import pandemicBase.ConsoleView;
import pandemicBase.Cube;
import pandemicBase.CubeList;
import pandemicBase.CureMarker;
import pandemicBase.CureMarkerList;
import pandemicBase.EpidemicCard;
import pandemicBase.InfectionCard;
import pandemicBase.InfectionDeck;
import pandemicBase.InfectionDiscardPile;
import pandemicBase.InfectionEpidemic;
import pandemicBase.InfectionGamePhase;
import pandemicBase.InfectionTrack;
import pandemicBase.OutbreakTrack;
import pandemicBase.Player;
import pandemicBase.PlayerDeck;
import pandemicBase.PlayerHand;
import pandemicBase.PlayerList;
import pandemicBaseRoles.Medic;
import pandemicBaseRoles.OperationsExpert;
import pandemicBaseRoles.QuarantineSpecialist;
import pandemicBaseRoles.Researcher;
import pandemicBaseRoles.Scientist;
import rules.RuleThereMustBeEnoughPlayerCards;


public class PandemicOriginalReferee extends AbstractReferee {
	public PandemicOriginalReferee(AbstractGameConfiguration gameConfiguration) {
		super(gameConfiguration);
		setView(new ConsoleView());
	}

	@Override
	protected void setup() {
		setupBoardMVC();
		setupPlayerAndInfectionDecks();
		setupPlayers();
		addEpidemicCardToPlayerDeck(); 
		setupTracks();
		setupCubesAndMarkers();
		setupInfection();
		
		System.out.println("Game Set-Up ");
	}

	@Override
	protected void startGame() {
		endGame = false;
		while (!(endGame)) {
			conductPlayersTurn();
			
			if(endGame) break;
			conductGameTurn();
		}
		determineWinner();
		announceWinner();
		
	}
	protected void determinePlayerOrder(int i) { 
		currentPlayer = playerList.getPlayer(i);
	}
	
	protected void determineCurrentAction() {
		setCurrentAction(view.getActionChoiceFromPlayer(this)); 
	}
	protected void determineWinner() {
		if(cureMarkerList.areAllMarkersCured()) {
			setWinner("PLAYERS WON!!");
		}
	}
	protected void conductPlayersTurn() {
		
		int actionCount = 0;
		for (int i=0; i<numberOfPlayers;i++) {
			while(actionCount<4) {
				determinePlayerOrder(i);
				view.showActionOptions();
				determineCurrentAction();
				conductMove();
				actionCount++;
			}
			//Draw 2 cards after 4 actions.
			drawTwoCards();
		}
	}
	
	private void drawTwoCards() {
		IRule ruleForCardDrawing = new RuleThereMustBeEnoughPlayerCards();
		for(int j=0; j<2; j++) {
			if(ruleForCardDrawing.evaluate(this)) {
				view.showDeck(playerDeck);
				currentPlayerDrawnCard = view.getChosenCardFromPlayer(this);
				playerDeck.drawCardOnTopFromDeck(currentPlayerDrawnCard);
				if(currentPlayerDrawnCard instanceof EpidemicCard) {
					AbstractInfection infectionEpidemic = new InfectionEpidemic(this);
					infectionEpidemic.infect();
					view.showResponseToPlayer("Here is the newly infected cities after epidemic card resolve.");
					view.showNewlyInfectedNodeList(this);
				}
				else {
					currentPlayer.getHand().addCardToDeck(currentPlayerDrawnCard); 
					if(currentPlayer.getHand().size() > 7) {
						view.showResponseToPlayer("Please discard any card from your hand immediately.");
						view.showDeck(currentPlayer.getHand());
						AbstractCard card = view.getChosenCardFromPlayer(this);
						currentPlayer.discardCard(card);
					}
				}
			}
		}
	}
	
	protected void conductGameTurn() {
		int numOfCitiesWillBeInfected = ((InfectionTrack) infectionTrack).getNumberOfCitiesWillBeInfected();
		for (int i = 0; i < numOfCitiesWillBeInfected; i++) {
			AbstractInfection infectionGamePhase = new InfectionGamePhase(this);
			infectionGamePhase.infect();
			view.showResponseToPlayer("Here is the newly infected cities after infection. Don't forget to put related colored cubes to cities.");
			view.showNewlyInfectedNodeList(this);
		}
	}

	protected void announceWinner() {
		view.announceWinner(winner);
	}
	protected void conductMove() {
		if(checkAction()) {
			currentAction.takeAction();
		}
		
	}
	protected boolean checkAction() {
		return currentAction.isSatisfied();
	}
	
	private void setupBoardMVC() {
		List<AbstractBoardNode> boardNodes = gameConfiguration.getNodes();
		board = new Board(boardNodes);
		setInitialNode();
	}
	
	private void setInitialNode() {
		String initialNodeName = gameConfiguration.getInitialBoardNode();
		for (AbstractBoardNode boardNode : board.getNodeList()) {
			if(boardNode.getName().equals(initialNodeName)) {
				initialNode = boardNode;
			}
		}
	}
	
	private void setupPlayerAndInfectionDecks() {
		
		List<AbstractBoardNode> boardNodes = gameConfiguration.getNodes();
		List<AbstractCard> cityCardList = new ArrayList<AbstractCard>(); 
		List<AbstractCard> infectionCardList = new ArrayList<AbstractCard>(); 
		for (AbstractBoardNode boardNode : boardNodes) {
			
			CityCard cityCard = new CityCard(boardNode.getName(), ((BoardNode)boardNode).getPopulation(),((BoardNode)boardNode).getColor());
			cityCardList.add(cityCard);
			InfectionCard infectionCard = new InfectionCard(boardNode.getName(),((BoardNode)boardNode).getColor());
			infectionCardList.add(infectionCard);
		}
		
		playerDeck = new PlayerDeck(cityCardList);
		infectionDeck = new InfectionDeck(infectionCardList);
		infectionDiscardPile = new InfectionDiscardPile();
		infectionDeck.shuffle();
	}
	private void addEpidemicCardToPlayerDeck() {
		numberOfEpidemicCards = gameConfiguration.getNumberOfEpidemicCardsInGame();
		AbstractCard epidemicCard = new EpidemicCard();
		((PlayerDeck) playerDeck).insertEpidemicCard(0,epidemicCard);
			
	}
	private void setupTracks() {
		infectionTrack = new InfectionTrack(gameConfiguration.getValuesOfInfectionRateNumber());
		outbreakTrack = new OutbreakTrack(gameConfiguration.getOutbreakRange());
	}
	private void setupCubesAndMarkers() {
		Set<Color> colorSet = new HashSet<Color>();
		for (AbstractBoardNode node : board.getNodeList()) {
			colorSet.add(((BoardNode) node).getColor());
		}
		numberOfDiseaseCubesPerType = gameConfiguration.getNumberOfDiseaseCubePerCubeType();
		cubeList = new CubeList();
		cureMarkerList = new CureMarkerList();
		for (Color color : colorSet) {
			cureMarkerList.addCureMarker(new CureMarker(color));
			List<AbstractGamePiece> sameColorCubeList = new ArrayList<AbstractGamePiece>();
			for (int j = 0; j < numberOfDiseaseCubesPerType; j++) {
				AbstractGamePiece cube = new Cube( color);
				sameColorCubeList.add(cube);
			}
			cubeList.addSameColorCubeList(sameColorCubeList);
		}
	}
	private void setupInfection() {
		//infect cities with 3 cubes
		for (int i = 0; i < 3; i++) {
			AbstractCard infectedWithThreeCubesCityCard= infectionDeck.drawCardOnTopFromDeck();
			infectionDiscardPile.addCardToDeck(infectedWithThreeCubesCityCard);
			String cityName = infectedWithThreeCubesCityCard.getName();
			BoardNode infectedWithThreeCubesCityNode = (BoardNode) board.getBoardNode(cityName);
			Color cubeColor = infectedWithThreeCubesCityNode.getColor();
			for (int j = 0; j < 3; j++) {
				Cube cube = (Cube) cubeList.takeCubeFromCubeList(cubeColor);
				infectedWithThreeCubesCityNode.addPieceOnNode(cube);
			}
		}
		// infect cities with 2 cubes
		for (int i = 0; i < 3; i++) {
			AbstractCard infectedWithTwoCubesCityCard= infectionDeck.drawCardOnTopFromDeck();
			infectionDiscardPile.addCardToDeck(infectedWithTwoCubesCityCard);
			String cityName = infectedWithTwoCubesCityCard.getName();
			BoardNode infectedWithTwoCubesCityNode = (BoardNode) board.getBoardNode(cityName);
			Color cubeColor = infectedWithTwoCubesCityNode.getColor();
			for (int j = 0; j < 2; j++) {
				Cube cube = (Cube) cubeList.takeCubeFromCubeList(cubeColor);
				infectedWithTwoCubesCityNode.addPieceOnNode(cube);
			}
		}
		// infect cities with 1 cube
		for (int i = 0; i < 3; i++) {
			AbstractCard infectedWithOneCubeCityCard= infectionDeck.drawCardOnTopFromDeck();
			infectionDiscardPile.addCardToDeck(infectedWithOneCubeCityCard);
			String cityName = infectedWithOneCubeCityCard.getName();
			BoardNode infectedWithOneCubeCityNode = (BoardNode) board.getBoardNode(cityName);
			Color cubeColor = infectedWithOneCubeCityNode.getColor();
			Cube cube = (Cube) cubeList.takeCubeFromCubeList(cubeColor);
			infectedWithOneCubeCityNode.addPieceOnNode(cube);	
		}
	}

	private void setupPlayers() {
		numberOfPlayers = gameConfiguration.getNumberOfPlayers();
		playerList = new PlayerList();
		for (int i = 0; i < numberOfPlayers; i++) {
			AbstractPlayer player = new Player(setupPlayerHandDeck(),setupRoles().get(i),i,initialNode);
			playerList.addPlayer(player);
		}
		sortPlayerListAccordingToMaxPopulation();
	}
	
	
	private void sortPlayerListAccordingToMaxPopulation(){
		Collections.sort(playerList.getPlayers(), (player1, player2) -> player2.getOrder() - player1.getOrder());
	}

	
	private AbstractDeck setupPlayerHandDeck() {
		numberOfCardsPerPlayer = gameConfiguration.getNumberOfCardsPerPlayer();
		List<AbstractCard> deck = new ArrayList<AbstractCard>();
		for (int j = 0; j < numberOfCardsPerPlayer; j++) {
			view.showDeck(playerDeck);
			AbstractCard drawnCard = view.getChosenCardFromPlayer(this);
			playerDeck.drawCardOnTopFromDeck(drawnCard); 
			deck.add(drawnCard);
		}
		AbstractHandDeck handDeck = new PlayerHand(deck); 
		return handDeck;
	}
	private List<AbstractRole> setupRoles() {
		List<String> roleNameList = gameConfiguration.getNameOfRoles();
		List<AbstractRole> roleList = new ArrayList<AbstractRole>();
		
		AbstractRole role = null;
		for (String name : roleNameList) {
			switch (name) {
			case "Medic":
				role = new Medic();
				break;
			case "Researcher":
				role = new Researcher();
				break;
			case "Scientist":
				role = new Scientist();
				break;
			case "OperationsExpert":
				role = new OperationsExpert();
				break;
			case "QuarantineSpecialist":
				role = new QuarantineSpecialist();
				break;
			}
			roleList.add(role);
		}
		Collections.shuffle(roleList);
		return roleList;
	}

}
