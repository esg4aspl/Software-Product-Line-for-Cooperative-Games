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
import pandemicBase.ResearchStation;
import pandemicBaseRoles.Medic;
import pandemicBaseRoles.OperationsExpert;
import pandemicBaseRoles.QuarantineSpecialist;
import pandemicBaseRoles.Researcher;
import pandemicBaseRoles.Scientist;
import rules.RuleThereMustBeEnoughPlayerCards;


public class PandemicVol1Referee extends AbstractReferee {
	public PandemicVol1Referee(AbstractGameConfiguration gameConfiguration) {
		super(gameConfiguration);
		setView(new PandemicVol1ConsoleView());
	}

	@Override
	protected void setup() {
		view.showSetUpInformation();
		setupBoardMVC();
		setupPlayerAndInfectionDecks();
		setupPlayers();
		addEpidemicCardToPlayerDeck(); 
		setupTracks();
		setupCubesAndMarkers();
		setupInfection();
	}

	@Override
	protected void startGame() {
		endGame = false;
		while (!(endGame)) {
			view.showBoardStatue(this);
			
			for (int i=0; i<numberOfPlayers;i++) {
				determinePlayerOrder(i);
				view.showResponseToPlayer(playerList.getPlayerStatus());
				view.showResponseToPlayer("CurrentPlayer: " + currentPlayer.getRole().toString()+"\n");
				conductPlayerTurn();
				if(endGame){
					break;
				}
				conductGameTurn();
				if(endGame){
					break;
				}
			}
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
	protected void conductPlayerTurn() {
		int actionCount = 4;
		while(actionCount>0 && (!endGame)) {
			view.showResponseToPlayer("Remaining actions "+ actionCount + " for: " + currentPlayer.getRole().getName());
			conductMove(actionCount);
			view.showBoardStatue(this);
			actionCount--;
		}
		//Draw 2 cards after 4 actions.
		
		drawTwoCards();
		
	}
	
	
	private void drawTwoCards() {
		IRule ruleForCardDrawing = new RuleThereMustBeEnoughPlayerCards();
		for(int j=0; j<2; j++) {
			if(ruleForCardDrawing.evaluate(this)) {
				currentPlayerDrawnCard = view.getChosenCardFromPlayer(playerDeck);
				if(currentPlayerDrawnCard instanceof EpidemicCard) {
					AbstractInfection infectionEpidemic = new InfectionEpidemic(this);
					infectionEpidemic.infect();
					view.showNewlyInfectedNodeList(this);
				}
				else {
					playerDeck.drawCardOnTopFromDeck(currentPlayerDrawnCard);
					currentPlayer.getHand().addCardToDeck(currentPlayerDrawnCard); 
					if(currentPlayer.getHand().size() > 7) {
						view.showResponseToPlayer("You exceed the hand limit! Please discard any card from your hand immediately.");
						AbstractCard card = view.getChosenCardFromPlayer(currentPlayer.getHand());
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
			view.showNewlyInfectedNodeList(this);
		}
	}

	protected void announceWinner() {
		view.announceWinner(winner);
	}
	protected void conductMove(int actionCount) {
		view.showActionOptions();
		determineCurrentAction();
		if(checkAction()) {
			currentAction.takeAction();
		}
		else {
			view.showResponseToPlayer("This action can not be done. Please try again.");
			view.showResponseToPlayer("Remaining actions "+ actionCount + " for:" + currentPlayer.getRole().getName());
			conductMove(actionCount);
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
		((BoardNode)initialNode).addPieceOnNode(new ResearchStation());
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
		setUsedColorSet(colorSet);
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
		List<AbstractRole> roleList = setupRoles();
		for (int i = 0; i < numberOfPlayers; i++) {
			AbstractPlayer player = new Player(setupPlayerHandDeck(roleList.get(i)),roleList.get(i),i,initialNode);
			((BoardNode)initialNode).addPlayersOnTheNode(player);
			playerList.addPlayer(player);
		}
		sortPlayerListAccordingToMaxPopulation();
	}
		
	private void sortPlayerListAccordingToMaxPopulation(){
		Collections.sort(playerList.getPlayers(), (player1, player2) -> player2.getOrder() - player1.getOrder());
	}

	
	private AbstractDeck setupPlayerHandDeck(AbstractRole role) {
		numberOfCardsPerPlayer = gameConfiguration.getNumberOfCardsPerPlayer();
		List<AbstractCard> deck = new ArrayList<AbstractCard>();
		view.showResponseToPlayer("Player role: " + role.getName() +" enters hand!");
		for (int j = 0; j < numberOfCardsPerPlayer; j++) {
			AbstractCard drawnCard = view.getChosenCardFromPlayer(playerDeck);
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
