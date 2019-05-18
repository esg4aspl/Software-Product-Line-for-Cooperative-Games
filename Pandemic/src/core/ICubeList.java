package core;

import java.util.List;

public interface ICubeList {
	public void addCubeToCubeList(AbstractGamePiece cube);
	public AbstractGamePiece takeCubeFromCubeList(Color colorOfCube);
	public List<List<AbstractGamePiece>> getCubes();
	public boolean areThereEnoughCubesOfSpecificColor(Color colorOfCube);
	public void addSameColorCubeList(List<AbstractGamePiece> sameColorCubeList);
}
