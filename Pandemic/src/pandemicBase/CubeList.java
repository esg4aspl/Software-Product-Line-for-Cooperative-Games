package pandemicBase;

import java.util.ArrayList;
import java.util.List;

import core.AbstractGamePiece;
import core.ICubeList;
import core.Color;

public class CubeList implements ICubeList{
	private List<List<AbstractGamePiece>> cubeList;
	
	public CubeList() {
		this.cubeList = new ArrayList<List<AbstractGamePiece>>();
	}

	@Override
	//Add cube to cubeList according to the color.
	public void addCubeToCubeList(AbstractGamePiece cube) {
		Color colorOfCube = ((Cube)cube).getColor();
		for (List<AbstractGamePiece> listOfSameColorCube : cubeList) {
			if(colorOfCube.equals(((Cube) listOfSameColorCube.get(0)).getColor())) {
				listOfSameColorCube.add(cube);
			}
		}
	}

	@Override
	//Find the right cube according to the color and remove it from the list to put it on the board.
	public AbstractGamePiece takeCubeFromCubeList(Color colorOfCube) {
		AbstractGamePiece cube = null;
		for (List<AbstractGamePiece> listOfSameColorCube : cubeList) {
			if(colorOfCube.equals(((Cube) listOfSameColorCube.get(0)).getColor())) {
				cube = listOfSameColorCube.remove(0);
			}
		}
		return cube;
		
	}

	@Override
	public List<List<AbstractGamePiece>> getCubes() {
		return cubeList;
	}
}