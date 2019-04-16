package core;

import java.util.List;

public abstract class AbstractGameConfiguration {
	//buraya db ya da xml dosyas�ndan okumam�z� sa�layacak tatl� bir de�i�ken gelecek !!!
	//TODO ICONFIGFILE gibi bir de�i�ken yaaaaz!!!
	public AbstractGameConfiguration() {
	}
	//DiseaseCubeTypelar al�n�nca, dolayl� olarak cure marker say�s�n� ve tipini de alm�� oluyoruz.
	public abstract int getNumberOfDiseaseCubeTypes();
	public abstract int getNumberOfDiseaseCubePerCubeType();
	public abstract int getOutbreakRange();
	public abstract int getNumberOfPlayers();
	public abstract int getNumberOfCardsPerPlayer();
	public abstract int[] getValuesOfInfectionRateNumber();
	public abstract int getNumberOfNodes();
	public abstract String getInitialBoardNode();
	//Node'lar�n ismini al�nca, otomatik olarak city card ve infection card isimlerini de alm�� oluyoruz.
	public abstract List<AbstractBoardNode> getNodes();
	public abstract int getNumberOfEpidemicCardsInGame();
	// kart isimleri al�nacak, isimlerin objelere map edilmesi referee sayesinde olacak.
	public abstract List<String> getNameOfEventCards(); 
	public abstract List<String> getNameOfRoleCards();
	

}
