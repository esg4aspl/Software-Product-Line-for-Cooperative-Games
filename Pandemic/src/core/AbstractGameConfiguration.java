package core;

import java.util.List;

public abstract class AbstractGameConfiguration {
	//buraya db ya da xml dosyas�ndan okumam�z� sa�layacak tatl� bir de�i�ken gelecek
	public AbstractGameConfiguration() {
		
	}
	public abstract int getNumberOfDiseaseCubes();
	public abstract int getOutbreakRange();
	public abstract int getNumberOfPlayers();
	public abstract int getNumberOfCardsPerPlayer();
	public abstract List<Integer> getValuesOfInfectionRateNumber();
	public abstract int getNumberOfNodes();
	public abstract String getInitialBoardNode();
	public abstract List<AbstractBoardNode> getNodes();
	public abstract	List<List<AbstractBoardNode>> getNeighbours();

}
