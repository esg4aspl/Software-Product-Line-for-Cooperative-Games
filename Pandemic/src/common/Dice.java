package common;
import java.util.ArrayList;
import java.util.Random;

public class Dice extends AbstractGamePieces {
	private ArrayList<Integer> faces = new ArrayList<Integer>();
	
	public Dice(int id) {
		super(id);
	}
	public Dice() {
		setFaces();
	}

	public ArrayList<Integer> getFaces() {
		return faces;
	}

	private void setFaces() {
		for(int i= 0; i<6; i++) {
			this.faces.add(i+1);
		}
	}
	public int roll() {
		int face =(new Random().nextInt(6)) +1 ;
		return face;
	}
}
