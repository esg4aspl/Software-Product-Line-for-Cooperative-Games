package core;

import java.util.List;

public abstract class AbstractGameConfiguration {
	//buraya db ya da xml dosyasýndan okumamýzý saðlayacak tatlý bir deðiþken gelecek !!!
	//TODO ICONFIGFILE gibi bir deðiþken yaaaaz!!!
	public AbstractGameConfiguration() {
	}
	//DiseaseCubeTypelar alýnýnca, dolaylý olarak cure marker sayýsýný ve tipini de almýþ oluyoruz.
	public abstract int getNumberOfDiseaseCubeTypes();
	public abstract int getNumberOfDiseaseCubePerCubeType();
	public abstract int getOutbreakRange();
	public abstract int getNumberOfPlayers();
	public abstract int getNumberOfCardsPerPlayer();
	public abstract int[] getValuesOfInfectionRateNumber();
	public abstract int getNumberOfNodes();
	public abstract String getInitialBoardNode();
	//Node'larýn ismini alýnca, otomatik olarak city card ve infection card isimlerini de almýþ oluyoruz.
	public abstract List<AbstractBoardNode> getNodes();
	public abstract int getNumberOfEpidemicCardsInGame();
	// kart isimleri alýnacak, isimlerin objelere map edilmesi referee sayesinde olacak.
	public abstract List<String> getNameOfEventCards(); 
	public abstract List<String> getNameOfRoleCards();
	

}
