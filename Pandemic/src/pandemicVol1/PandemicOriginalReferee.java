package pandemicVol1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import core.AbstractAction;
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
import core.IPlayerList;
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
import pandemicBase.InfectionGamePhase;
import pandemicBase.InfectionTrack;
import pandemicBase.OutbreakTrack;
import pandemicBase.Player;
import pandemicBase.PlayerDeck;
import pandemicBase.PlayerHand;
import pandemicBase.PlayerList;
import pandemicBaseRoles.Medic;
import pandemicBaseRoles.Researcher;


public class PandemicOriginalReferee extends AbstractReferee {
	public PandemicOriginalReferee(AbstractGameConfiguration gameConfiguration) {
		super(gameConfiguration);
		setView(new ConsoleView());
	}

	@Override
	public void setup() {
		setupBoardMVC();
		setupPlayerAndInfectionDecks();
		setupPlayers();
		addEpidemicCardsToPlayerDeck(); // TODO Please look this method 
		setupTracks();
		setupCubesAndMarkers();
		setupInfection();
		
		System.out.println("Game Set-Up ");
	}

	@Override
	public void startGame() {
		endGame = false;
		while (!(endGame)) {
			conductPlayersTurn();
			if(endGame) break;
			conductGameTurn();
		}
		
		announceWinner("bittiii kazandk"); //burda argüman olarak 114.satýrda bahsettiðim attribute gönderilmeli.
		
	}
	private void determinePlayerOrder(int i) { 
		//... currentPlayer = blablabla //bunu abstract'a çekebiliriz 
		currentPlayer = playerList.getPlayer(i);
	
	}
	
	private void determineCurrentAction() {
		setCurrentAction(view.getActionChoiceFromPlayer(this)); 
	}

	public void conductPlayersTurn() {
		
		int actionCount = 0;
		for (int i=0; i<numberOfPlayers;i++) {
			while(actionCount<4) {
			determinePlayerOrder(i);
			//actionlarý listele consoledan
			view.showActionOptions();
			determineCurrentAction();
			conductMove();
			actionCount++;
			}
			//move yaptýktan sonra kart çekimi
			for(int j=0; j<2; j++) {
				view.ShowPlayDeck(this);
				currentPlayerDrawnCard = view.getDrawnCardFromPlayer(this);
				playerDeck.drawCardOnTopFromDeck(currentPlayerDrawnCard); //bu fonksiyon deðiþttiiiiii,overload
				//city kartlarý numaralandýrarak consola bastýr.
				//drawn kartýn sor i view ile
				//draw kartý playerden konsol aracýlýðýyla alacaksak :
				//currentPlayerDrawnCard= consoleView.getDrawnCardFromPlayer();
				if(currentPlayerDrawnCard instanceof EpidemicCard) {
					//epidemicCardResolution() diye bir fonksiyon lazým gelir.
				}
				else {
					currentPlayer.getHand().addCardToDeck(currentPlayerDrawnCard); //player handý referee tutmasýn hep playerdan ulaþýyoruz zaten 
				}
			
			}
		}
		
	}
	
	private void conductGameTurn() {
		int numOfCitiesWillBeInfected = ((InfectionTrack) infectionTrack).getNumberOfCitiesWillBeInfected();
		for (int i = 0; i < numOfCitiesWillBeInfected; i++) {
			AbstractInfection infectionGamePhase = new InfectionGamePhase(this);
			infectionGamePhase.infect();
		}
	}
	
	public void announceWinner(String winner) {
		view.announceWinner(winner);
	}
	private void conductMove() {
		checkAction(currentAction);
		
	}
	private boolean checkAction(AbstractAction currentAction) {
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
		playerDeck.shuffle();
		infectionDeck.shuffle();
	}
	private void addEpidemicCardsToPlayerDeck() {
		numberOfEpidemicCards = gameConfiguration.getNumberOfEpidemicCardsInGame();
		int indexToAdd = playerDeck.size() % numberOfEpidemicCards;
		for (int i = 1; i <= numberOfEpidemicCards; i++) {
			AbstractCard epidemicCard = new EpidemicCard();
			((PlayerDeck) playerDeck).insertEpidemicCard(indexToAdd,epidemicCard);
			indexToAdd = indexToAdd * i;
		}	
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
		playerList = sortPlayerListAccordingToMaxPopulation( playerList);
	}
	
	
	private IPlayerList sortPlayerListAccordingToMaxPopulation(IPlayerList playerList){
		//TODO sort 
		return playerList;
		
	}
	
	private AbstractDeck setupPlayerHandDeck() {
		numberOfCardsPerPlayer = gameConfiguration.getNumberOfCardsPerPlayer();
		List<AbstractCard> deck = new ArrayList<AbstractCard>();
		for (int j = 0; j < numberOfCardsPerPlayer; j++) {
			AbstractCard drawnCard = view.getDrawnCardFromPlayer(this);
			playerDeck.drawCardOnTopFromDeck(drawnCard); 
			deck.add(drawnCard);
		}
		AbstractHandDeck handDeck = new PlayerHand(deck); 
		return handDeck;
	}
	private List<AbstractRole> setupRoles() {// GAME CONFIG and this will be changed
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
			default:
				break;
			}
			roleList.add(role);
		}
		Collections.shuffle(roleList);
		return roleList;
	}
	
	

	
}
