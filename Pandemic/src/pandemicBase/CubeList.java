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
		for (List<AbstractGamePiece> listOfCubesOfSameColor : cubeList) {
			Cube sampleCube = (Cube) listOfCubesOfSameColor.get(0);
			if(sampleCube != null) {
				Color colorOfSampleCube = sampleCube.getColor();
				if(colorOfCube.equals(colorOfSampleCube)) {
					cube = listOfCubesOfSameColor.remove(0);
				}
			}
			
		}
		return cube;
		
	}
	//Check if there are enough cubes of specific color 
	public boolean areThereEnoughCubesOfSpecificColor(Color colorOfCube) {
		for (List<AbstractGamePiece> listOfCubesOfSameColor : cubeList) {
			Cube sampleCube = (Cube) listOfCubesOfSameColor.get(0);
			if(sampleCube != null) {
				Color colorOfSampleCube = sampleCube.getColor();
				if(colorOfCube.equals(colorOfSampleCube)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<List<AbstractGamePiece>> getCubes() {
		return cubeList;
	}

	@Override
	public void addSameColorCubeList(List<AbstractGamePiece> sameColorCubeList) {
		cubeList.add(sameColorCubeList);
		
	}
}
