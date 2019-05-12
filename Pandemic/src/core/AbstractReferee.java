package core;

public abstract class AbstractReferee {
	protected AbstractGameConfiguration gameConfiguration;
	protected int  numberOfPlayers, numberOfCardsPerPlayer,numberOfNodes,numberOfDiseaseCubeTypes,numberOfDiseaseCubesPerType,numberOfEpidemicCards;
	protected IPlayerList playerList;
	protected ICubeList cubeList;
	protected ICureMarkerList cureMarkerList;
	protected AbstractStackDeck playerDeck;
	protected AbstractStackDeck infectionDeck;
	protected AbstractDeck infectionDiscardPile;
	protected AbstractTrack infectionTrack;
	protected AbstractTrack outbreakTrack;
	protected AbstractBoardNode initialNode;
	protected AbstractBoard board;
	
	protected AbstractPlayer currentPlayer;
	protected AbstractCard currentPlayerDrawnCard;
	protected AbstractAction currentAction;
	protected AbstractBoardNode currentNode;
	
	protected IView view;
	
	protected boolean endGame;

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

	public ICureMarkerList getCureMarkerList() {
		return cureMarkerList;
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

	public AbstractStackDeck getInfectionDeck() {
		return infectionDeck;
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
	
	public AbstractDeck getInfectionDiscardPile() {
		return infectionDiscardPile;
	}


	public AbstractTrack getInfectionTrack() {
		return infectionTrack;
	}


	public AbstractTrack getOutbreakTrack() {
		return outbreakTrack;
	}

	public  AbstractDeck getPlayerDeck() {
		return playerDeck;
	}
	
	public ICubeList getCubeList() {
		return cubeList;
	}

	public IView getView() {
		return view;
	}


	public void setView(IView view) {
		this.view = view;
	}
	
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	
	public abstract void setup();
	public abstract void startGame();


	
	

}
