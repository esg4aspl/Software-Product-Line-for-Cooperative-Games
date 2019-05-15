package core;

import java.util.List;

public abstract class AbstractGameConfiguration {
	//TODO We are going to write ICONFIG variable, that's why this class is abstract. 
	public AbstractGameConfiguration() {
	}
	//When we get the Disease Cube types, we automatically get number of cure markers and type of markers.
	public abstract int getNumberOfDiseaseCubeTypes();
	public abstract int getNumberOfDiseaseCubePerCubeType();
	public abstract int getOutbreakRange();
	public abstract int getNumberOfPlayers();
	public abstract int getNumberOfCardsPerPlayer();
	public abstract int[] getValuesOfInfectionRateNumber();
	public abstract int getNumberOfNodes();
	public abstract String getInitialBoardNode();
	//When we getNodes we automatically have cityCard names and InfectionCard names. 
	public abstract List<AbstractBoardNode> getNodes();
	// We get the name of cards and description, the mapping these informations to objects is referee's job.
	public abstract List<String> getNameOfRoles();

}
