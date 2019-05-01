package core;

import java.util.List;

public abstract class AbstractReferee {
	protected AbstractGameConfiguration gameConfiguration;
	protected int  numberOfPlayers, numberOfCardsPerPlayer,numberOfNodes,numberOfDiseaseCubeTypes,numberOfDiseaseCubesPerType,numberOfEpidemicCards;
	protected IPlayerList playerList;
	protected ICubeList cubeList;
	protected AbstractStackDeck playerDeck;
	protected AbstractStackDeck infectionDeck;
	protected AbstractDeck playerDiscardPile; // deck for discarded card. It is useful for an event card. 
	protected AbstractDeck infectionDiscardPile;
	protected AbstractTrack infectionTrack;
	protected AbstractTrack outbreakTrack;
	protected AbstractBoardNode initialNode;
	protected AbstractBoard board;
	
	protected AbstractPlayer currentPlayer;
	protected AbstractCard currentPlayerDrawnCard;
	protected AbstractAction currentAction;
	protected AbstractBoardNode currentNode;
		
	
	
	public AbstractReferee(AbstractGameConfiguration gameConfiguration) {
		setGameConfiguration(gameConfiguration);
	}

	public AbstractGameConfiguration getGameConfiguration() {
		return gameConfiguration;
	}

	public void setGameConfiguration(AbstractGameConfiguration gameConfiguration) {
		this.gameConfiguration = gameConfiguration;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	
	public int getNumberOfCardsPerPlayer() {
		return numberOfCardsPerPlayer;
	}

	public void setNumberOfCardsPerPlayer(int numberOfCardsPerPlayer) {
		this.numberOfCardsPerPlayer = numberOfCardsPerPlayer;
	}


	public IPlayerList getPlayerList() {
		return playerList;
	}

	public void setPlayerList(IPlayerList playerList) {
		this.playerList = playerList;
	}

	public AbstractPlayer getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(AbstractPlayer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public AbstractAction getCurrentAction() {
		return currentAction;
	}

	public void setCurrentAction(AbstractAction currentAction) {
		this.currentAction = currentAction;
	}

	public AbstractBoardNode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(AbstractBoardNode currentNode) {
		this.currentNode = currentNode;
	}

	public AbstractBoard getBoard() {
		return board;
	}

	public void setBoard(AbstractBoard board) {
		this.board = board;
	}
	
	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}


	public AbstractCard getCurrentPlayerDrawnCard() {
		return currentPlayerDrawnCard;
	}

	public void setCurrentPlayerDrawnCard(AbstractCard currentPlayerDrawnCard) {
		this.currentPlayerDrawnCard = currentPlayerDrawnCard;
	}
	
	public AbstractDeck getPlayerDiscardPile() {
		return playerDiscardPile;
	}
	public abstract void setup();
	public abstract void startGame();
	
	

}
