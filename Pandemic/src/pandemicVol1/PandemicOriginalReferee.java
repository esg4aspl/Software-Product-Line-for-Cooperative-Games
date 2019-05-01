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
import core.AbstractPlayer;
import core.AbstractReferee;
import core.AbstractRole;
import core.Color;
import core.Event;
import pandemicBase.Board;
import pandemicBase.BoardNode;
import pandemicBase.CityCard;
import pandemicBase.Cube;
import pandemicBase.CubeList;
import pandemicBase.EpidemicCard;
import pandemicBase.EventCard;
import pandemicBase.InfectionCard;
import pandemicBase.InfectionDeck;
import pandemicBase.InfectionDiscardPile;
import pandemicBase.InfectionTrack;
import pandemicBase.OutbreakTrack;
import pandemicBase.Player;
import pandemicBase.PlayerDeck;
import pandemicBase.PlayerDiscardPile;
import pandemicBase.PlayerHand;
import pandemicBase.PlayerList;
import pandemicBaseEventCards.Airlift;
import pandemicBaseRoles.Dispatcher;
import pandemicBaseRoles.Medic;


public class PandemicOriginalReferee extends AbstractReferee {
	public PandemicOriginalReferee(AbstractGameConfiguration gameConfiguration) {
		super(gameConfiguration);
	}

	@Override
	public void setup() {
		setupBoardMVC();
		setupPlayerAndInfectionDecks();
		setupPlayers();
		addEpidemicCardsToPlayerDeck();
		setupTracks();
		setupCubes();
		setupInfection();
		
		System.out.println("Game Set-Up ");
	}

	@Override
	public void startGame() {
		
	}
	
	private void conductMove() {
		checkAction(currentAction);
		// Preparing... 
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
			InfectionCard infectionCard = new InfectionCard(boardNode.getName());
			infectionCardList.add(infectionCard);
		}
		
		playerDeck = new PlayerDeck(cityCardList);
		playerDiscardPile = new PlayerDiscardPile();
		infectionDeck = new InfectionDeck(infectionCardList);
		infectionDiscardPile = new InfectionDiscardPile();
		
		List<String> eventCardNameList = gameConfiguration.getNameOfEventCards();
		EventCard eventCard = null;
		for (String evenCardName : eventCardNameList ){
			switch (evenCardName) {
			case "Airlift":
				eventCard = new Airlift(Event.Airlift);
				break;
			}
			playerDeck.addCardToDeck(eventCard);
		}
		
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
	private void setupCubes() {
		Set<Color> colorSet = new HashSet<Color>();
		for (AbstractBoardNode node : board.getNodeList()) {
			colorSet.add(((BoardNode) node).getColor());
		}
		
		Object[] colorArray = colorSet.toArray();
		numberOfDiseaseCubesPerType = gameConfiguration.getNumberOfDiseaseCubePerCubeType();
		cubeList = new CubeList();
		for (int i = 0; i < colorArray.length; i++) {
			for (int j = 0; j < numberOfDiseaseCubesPerType; j++) {
				AbstractGamePiece cube = new Cube( (Color) colorArray[i]);
				cubeList.addCubeToCubeList(cube);
			}
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
				infectedWithThreeCubesCityNode.addPieceOnTheNode(cube);
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
				infectedWithTwoCubesCityNode.addPieceOnTheNode(cube);
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
			infectedWithOneCubeCityNode.addPieceOnTheNode(cube);	
		}
	}
	
	private void setupPlayers() {
		numberOfPlayers = gameConfiguration.getNumberOfPlayers();
		playerList = new PlayerList();
		for (int i = 0; i < numberOfPlayers; i++) {
			AbstractPlayer player = new Player(setupPlayerHandDeck(),setupRoles().get(i),i,initialNode);
			playerList.addPlayer(player);
		}
		
	}
	private AbstractDeck setupPlayerHandDeck() {
		numberOfCardsPerPlayer = gameConfiguration.getNumberOfCardsPerPlayer();
		List<AbstractCard> deck = new ArrayList<AbstractCard>();
		for (int j = 0; j < numberOfCardsPerPlayer; j++) {
			deck.add(((PlayerDeck)playerDeck).drawCardOnTopFromDeck());
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
			case "Dispatcher":
				role = new Dispatcher();
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
