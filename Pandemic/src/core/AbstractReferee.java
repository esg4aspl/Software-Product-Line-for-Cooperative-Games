package core;

import java.util.List;

import pandemicBase.BoardNode;

public abstract class AbstractReferee {
	protected AbstractGameConfiguration gameConfiguration;
	protected int  numberOfPlayers, numberOfCardsPerPlayer,numberOfNodes,numberOfDiseaseCubes;
	protected List<Integer> valuesOfInfectionRate;
	protected IPlayerList playerList;
	protected Color currentPlayerColor;
	protected AbstractPlayer currentPlayer;
	protected AbstractCard currentPlayerDrawnCard;
	protected AbstractMove currentMove;
	protected AbstractBoardNode currentNode;
	protected AbstractBoard board;
	
	
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

	public Color getCurrentPlayerColor() {
		return currentPlayerColor;
	}

	public void setCurrentPlayerColor(Color currentPlayerColor) {
		this.currentPlayerColor = currentPlayerColor;
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

	public AbstractMove getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(AbstractMove currentMove) {
		this.currentMove = currentMove;
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

	public int getNumberOfDiseaseCubes() {
		return numberOfDiseaseCubes;
	}

	public void setNumberOfDiseaseCubes(int numberOfDiseaseCubes) {
		this.numberOfDiseaseCubes = numberOfDiseaseCubes;
	}

	public List<Integer> getValuesOfInfectionRate() {
		return valuesOfInfectionRate;
	}

	public void setValuesOfInfectionRate(List<Integer> valuesOfInfectionRate) {
		this.valuesOfInfectionRate = valuesOfInfectionRate;
	}

	public AbstractCard getCurrentPlayerDrawnCard() {
		return currentPlayerDrawnCard;
	}

	public void setCurrentPlayerDrawnCard(AbstractCard currentPlayerDrawnCard) {
		this.currentPlayerDrawnCard = currentPlayerDrawnCard;
	}

	public abstract void setUp();
	public abstract void startGame();
	

	
	
	

}
