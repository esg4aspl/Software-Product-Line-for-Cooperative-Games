package core;

import java.util.List;

public interface ICubeList {
	public void addCubeToCubeList(AbstractGamePiece cube);
	public AbstractGamePiece takeCubeFromCubeList(Color colorOfCube);
	public List<List<AbstractGamePiece>> getCubes();
}
